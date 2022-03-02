package com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity;

import com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity.vo.FailureReason;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRdo {
    //
    private boolean match;
    private FailureReason reason;
}
