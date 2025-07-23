package com.educandoweb.course.dto.payment;

import com.educandoweb.course.entities.PaymentEntity;

import java.time.Instant;

public record PaymentResponseDTO(Instant moment) {

    public static PaymentResponseDTO from(PaymentEntity entity) {
         return entity != null ? new PaymentResponseDTO(entity.getMoment()) : null;
    }

}
