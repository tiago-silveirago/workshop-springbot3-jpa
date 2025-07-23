package com.educandoweb.course.dto.order;

import com.educandoweb.course.dto.payment.PaymentResponseDTO;
import com.educandoweb.course.dto.user.UserResponseDTO;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.List;

public record OrderResponseDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
                               Instant moment,
                               OrderStatus orderStatus,
                               UserResponseDTO client,
                               List<com.educandoweb.course.dto.orderItem.OrderItemResponseDTO> items,
                               PaymentResponseDTO payment,
                               Double Total) {

}
