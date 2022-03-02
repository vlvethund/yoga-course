package com.mindeulle.yoga.course.aggregate.common.rest.command;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Command {
    //
    private String id;
    private LocalDateTime createTime;
    private CommandResponse commandResponse;

    public Command() {
        //
        this.id = UUID.randomUUID().toString();
        this.createTime = LocalDateTime.now();
    }
}
