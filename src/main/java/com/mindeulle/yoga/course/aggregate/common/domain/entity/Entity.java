package com.mindeulle.yoga.course.aggregate.common.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    //
    private String id;
    private String creator;
    private String modifier;
    private LocalDateTime created;
    private LocalDateTime modified;

}
