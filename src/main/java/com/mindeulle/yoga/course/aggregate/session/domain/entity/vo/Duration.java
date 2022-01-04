package com.mindeulle.yoga.course.aggregate.session.domain.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Duration {
    //
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
