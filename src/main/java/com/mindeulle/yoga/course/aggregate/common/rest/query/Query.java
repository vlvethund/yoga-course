package com.mindeulle.yoga.course.aggregate.common.rest.query;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Query<T> {
    private String id;
    private LocalDateTime createTime;
    private T queryResult;

    public Query() {
        this.id = UUID.randomUUID().toString();
        this.createTime = LocalDateTime.now();
    }
}
