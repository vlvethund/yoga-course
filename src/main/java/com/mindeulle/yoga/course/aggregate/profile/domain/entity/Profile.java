package com.mindeulle.yoga.course.aggregate.profile.domain.entity;

import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends Entity {
    //
    private String userId;
    private String name;
    private String password;
    private String mobile;

}
