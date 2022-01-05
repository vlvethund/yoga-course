package com.mindeulle.yoga.course.aggregate.profile.api.command.rest;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.domain.logic.ProfileLogic;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/aggregate/profile")
public class ProfileResource {

    private final ProfileLogic profileLogic;
    private final PasswordEncoder encoder;

    public ProfileResource(ProfileLogic profileLogic, PasswordEncoder encoder) {
        this.profileLogic = profileLogic;
        this.encoder = encoder;
    }

    @GetMapping("/save")
    public void saveProfile() {
        ProfileDoc profileDoc = new ProfileDoc("utiful204", "123", "이태겸","010467065342");

        Profile savedDoc = profileLogic.create(profileDoc);
        Profile retrieve = profileLogic.retrieve(savedDoc.getId());

        boolean matches = encoder.matches("123", retrieve.getPassword());

        System.out.println(matches);
        log.info(savedDoc.toString());
    }
}
