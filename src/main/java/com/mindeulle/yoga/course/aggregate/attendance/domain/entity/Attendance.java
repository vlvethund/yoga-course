package com.mindeulle.yoga.course.aggregate.attendance.domain.entity;

import com.mindeulle.yoga.course.aggregate.attendance.domain.entity.vo.AttendanceStatus;
import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance extends Entity {
    //
    private String session;
    private String attendee;
    private AttendanceStatus status;
}
