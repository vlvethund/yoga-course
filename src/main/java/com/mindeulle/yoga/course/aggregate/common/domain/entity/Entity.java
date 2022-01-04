package com.mindeulle.yoga.course.aggregate.common.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    //
    private String uuid;
    private String creator;
    private String modifier;
    private LocalDateTime created;
    private LocalDateTime modified;

}
