package com.mindeulle.yoga.course.aggregate.profile.api.command.command;

import com.mindeulle.yoga.course.aggregate.common.rest.command.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerificationCommand extends Command {
    //
   private String mobile;
}
