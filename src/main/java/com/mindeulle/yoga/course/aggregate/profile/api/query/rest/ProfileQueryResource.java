package com.mindeulle.yoga.course.aggregate.profile.api.query.rest;

import com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity.LoginRdo;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.LoginQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.MatchMobileVerificationQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.FindProfileQuery;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.vo.VerificationState;
import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.domain.logic.ProfileLogic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aggregate/profile/query")
public class ProfileQueryResource {
    //
    private final ProfileLogic profileLogic;

    public ProfileQueryResource(ProfileLogic profileLogic) {
        //
        this.profileLogic = profileLogic;
    }

    @PostMapping("/find-profile")
    public Profile findProfile(@RequestBody FindProfileQuery query) {
        //
        return profileLogic.retrieve(query).getQueryResult();
    }

    @PostMapping("/match-verification-code")
    public VerificationState matchVerificationCode(@RequestBody MatchMobileVerificationQuery query) {
        //
       return this.profileLogic.matchVerificationCode(query).getQueryResult();
    }

    @PostMapping("/login")
    public LoginRdo login(@RequestBody LoginQuery query) {

        return this.profileLogic.login(query).getQueryResult();
    }
}
