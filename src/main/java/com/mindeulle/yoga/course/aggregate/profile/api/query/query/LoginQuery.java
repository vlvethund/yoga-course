package com.mindeulle.yoga.course.aggregate.profile.api.query.query;

import com.mindeulle.yoga.course.aggregate.common.rest.query.Query;
import com.mindeulle.yoga.course.aggregate.profile.api.query.domain.entity.LoginRdo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginQuery extends Query<LoginRdo> {
    //
    private String userId;
    private String password;
}
