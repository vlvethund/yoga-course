package com.mindeulle.yoga.course.aggregate.profile.domain.entity;

import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends Entity {
    //
    private String name;
    private String password;
    private String mobile;

}
