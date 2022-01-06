package com.mindeulle.yoga.course.aggregate.profile.domain.entity;

import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MobileVerification extends Entity {
    private String mobile;
    private String verificationCode;
}
