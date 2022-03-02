package com.mindeulle.yoga.course.aggregate.profile.api.query.query;

import com.mindeulle.yoga.course.aggregate.common.rest.query.Query;
import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProfileQuery extends Query<Profile> {
    private String entityId;
}
