package com.mindeulle.yoga.course.aggregate.common.rest.command;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CommandResponse {
    //
    private String id;
    private LocalDateTime createTime;
    private String entityId;
    private List<String> entityIds;
    private boolean success;

    public CommandResponse() {
        //
        this.id = UUID.randomUUID().toString();
        this.createTime = LocalDateTime.now();
    }

    public CommandResponse(String entityId) {
        //
        this();
        this.entityId = entityId;
        this.success = true;
    }

    public CommandResponse(List<String> entityIds) {
        //
        this();
        this.entityIds = entityIds;
        this.success = true;
    }

    public CommandResponse(boolean bool) {
        this();
        this.success = bool;
    }
}
