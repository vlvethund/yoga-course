package com.mindeulle.yoga.course.aggregate.profile.domain.logic;

import com.mindeulle.yoga.course.aggregate.common.rest.command.CommandResponse;
import com.mindeulle.yoga.course.aggregate.profile.api.command.command.CreateProfileCommand;
import com.mindeulle.yoga.course.aggregate.profile.api.command.command.VerificationCommand;
import com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity.LoginRdo;
import com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity.vo.FailureReason;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.FindProfileQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.LoginQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.MatchMobileVerificationQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.vo.VerificationState;
import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Slf4j
@Service
@Transactional
public class ProfileLogic {
    //
    private final ProfileStore profileStore;
    private final StringRedisTemplate stringRedisTemplate;
    private final PasswordEncoder passwordEncoder;

    private final static int THREE_MINUTES = 3;

    public ProfileLogic(ProfileStore profileStore, StringRedisTemplate stringRedisTemplate, PasswordEncoder passwordEncoder) {
        //
        this.profileStore = profileStore;
        this.stringRedisTemplate = stringRedisTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public CreateProfileCommand create(CreateProfileCommand command) {
        //
        ProfileDoc profileDoc = new ProfileDoc(command.getUserId(), command.getPassword(), command.getName(), command.getMobile());

        command.setCommandResponse(new CommandResponse());
        String hashpw = BCrypt.hashpw(profileDoc.getPassword(), BCrypt.gensalt());
        profileDoc.setPassword(hashpw);
        ProfileDoc result = this.profileStore.create(profileDoc);
        log.info(String.format("Profile Created: [%s] %s", result.getId(), result.getUserId()));
        command.setCommandResponse(new CommandResponse(result.getId()));
        return command;
    }

    public VerificationCommand createVerificationCode(VerificationCommand command) {
        String randomNumericCode = RandomStringUtils.randomNumeric(6);
        stringRedisTemplate.opsForValue().set(command.getMobile(), randomNumericCode, Duration.ofMinutes(THREE_MINUTES));
        log.info(String.format("Mobile Verification Request: %s [%s]", command.getMobile(), randomNumericCode));
        command.setCommandResponse(new CommandResponse(true));
        return command;
    }

    public FindProfileQuery retrieve(FindProfileQuery query) {
        //
        Profile profile = profileStore.retrieve(query.getEntityId());
        log.info(String.format("Result for Searching Profile: [%s] %s", profile.getId(), profile.getUserId()));
        query.setQueryResult(profile);
        return query;
    }

    public MatchMobileVerificationQuery matchVerificationCode(MatchMobileVerificationQuery query) {
        //
        String userInputCode = query.getVerificationCode();
        String mobile = query.getMobile();

        String codeInRedis = stringRedisTemplate.opsForValue().get(mobile);

        if (StringUtils.isEmpty(codeInRedis)) {
            query.setQueryResult(VerificationState.TIME_OUT);
            log.info(String.format("Match Verification Result: [%s] %s", VerificationState.TIME_OUT, mobile));
        } else {
            if (codeInRedis.equals(userInputCode)) {
                query.setQueryResult(VerificationState.CERTIFICATED);
                log.info(String.format("Match Verification Result: [%s] %s", VerificationState.CERTIFICATED, mobile));
            } else {
                query.setQueryResult(VerificationState.WRONG_CODE);
                log.info(String.format("Match Verification Result: [%s] %s", VerificationState.WRONG_CODE, mobile));
            }
        }

        return query;
    }

    public LoginQuery login(LoginQuery query) {
        String userId = query.getUserId();
        String password = query.getPassword();

        Profile profile = profileStore.findByUserId(userId);

        if (ObjectUtils.isEmpty(profile)) {
            query.setQueryResult(LoginRdo.builder().match(false).reason(FailureReason.NO_SUCH_ID).build());
            log.info(String.format("LogIn Failed: [%s] %s", FailureReason.NO_SUCH_ID, userId));
            return query;
        }

        boolean matches = passwordEncoder.matches(password, profile.getPassword());

        if (matches) {
            query.setQueryResult(LoginRdo.builder().match(true).build());
            log.info(String.format("LogIn Success: %s", userId));
            return query;
        }

        query.setQueryResult(LoginRdo.builder().match(false).reason(FailureReason.WRONG_PASSWORD).build());
        log.info(String.format("LogIn Failed: [%s] %s", FailureReason.WRONG_PASSWORD, userId));
        return query;
    }
}
