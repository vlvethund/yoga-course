package com.mindeulle.yoga.course.aggregate.profile.api.command.rest;

import com.mindeulle.yoga.course.aggregate.common.rest.command.CommandResponse;
import com.mindeulle.yoga.course.aggregate.profile.api.command.command.CreateProfileCommand;
import com.mindeulle.yoga.course.aggregate.profile.api.command.command.VerificationCommand;
import com.mindeulle.yoga.course.aggregate.profile.domain.logic.ProfileLogic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aggregate/profile")
public class ProfileResource {

    private final ProfileLogic profileLogic;

    public ProfileResource(ProfileLogic profileLogic) {
        //
        this.profileLogic = profileLogic;
    }

    @PostMapping("/create-profile")
    public CommandResponse saveProfile(@RequestBody CreateProfileCommand command) {
        //
        return profileLogic.create(command).getCommandResponse();
    }



    @PostMapping("/request-mobile-verification")
    public CommandResponse createVerificationCode(@RequestBody VerificationCommand command) {
        //
        return profileLogic.createVerificationCode(command).getCommandResponse();
    }
}
