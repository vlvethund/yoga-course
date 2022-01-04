package com.mindeulle.yoga.course.aggregate.profile.api.command.rest;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.domain.logic.ProfileLogic;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/aggregate/profile")
public class ProfileResource {

    private final ProfileLogic profileLogic;

    public ProfileResource(ProfileLogic profileLogic) {
        this.profileLogic = profileLogic;
    }

    @GetMapping("/save")
    public void saveProfile() {
        ProfileDoc profileDoc = new ProfileDoc("이태겸", "123", "010467065342");
        profileDoc.setUuid(UUID.randomUUID().toString());
        Profile savedDoc = profileLogic.save(profileDoc);
        log.info(savedDoc.toString());
    }
}
