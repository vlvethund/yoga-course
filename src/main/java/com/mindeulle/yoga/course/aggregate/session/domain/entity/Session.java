package com.mindeulle.yoga.course.aggregate.session.domain.entity;

import com.mindeulle.yoga.course.aggregate.session.domain.entity.vo.Duration;
import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session extends Entity {
    //
    private String lecturer;
    private String subject;
    private Duration duration;
    private Integer quota;
}
