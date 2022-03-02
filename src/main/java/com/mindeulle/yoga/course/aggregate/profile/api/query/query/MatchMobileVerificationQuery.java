package com.mindeulle.yoga.course.aggregate.profile.api.query.query;

import com.mindeulle.yoga.course.aggregate.common.rest.query.Query;
import com.mindeulle.yoga.course.aggregate.profile.api.query.query.vo.VerificationState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchMobileVerificationQuery extends Query<VerificationState> {
    //
    private String mobile;
    private String verificationCode;
}
