package com.mindeulle.yoga.course.aggregate.payment.domain.entity;

import com.mindeulle.yoga.course.aggregate.common.domain.entity.Entity;
import com.mindeulle.yoga.course.aggregate.payment.domain.entity.vo.PaymentMethod;
import com.mindeulle.yoga.course.aggregate.payment.domain.entity.vo.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends Entity {
    //
    private Long price;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime expiryDate;
}
