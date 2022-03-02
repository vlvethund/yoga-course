package com.mindeulle.yoga.course.aggregate.profile.api.command.command;

import com.mindeulle.yoga.course.aggregate.common.rest.command.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProfileCommand extends Command {
    //
    private String userId;
    private String password;
    private String name;
    private String mobile;

}
