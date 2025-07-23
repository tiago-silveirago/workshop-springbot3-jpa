package com.educandoweb.course.factories;

import com.educandoweb.course.dto.order.OrderResponseDTO;
import com.educandoweb.course.dto.payment.PaymentResponseDTO;
import com.educandoweb.course.entities.OrderEntity;

import java.util.List;

public class OrderFactory {

    private OrderFactory() {
    }

    public static OrderResponseDTO convertToDto(OrderEntity order) {

        return new OrderResponseDTO(
                order.getMoment(),
                order.getOrderStatus(),
                UserFactory.convertToDto(order.getClient()),
                OrderItemFactory.convertToDto(order.getItems().stream().toList()),
                PaymentResponseDTO.from(order.getPayment()),
                order.getTotal());
    }

    public static List<OrderResponseDTO> convertToDto(List<OrderEntity> orders) {

        return orders.stream()
                .map(OrderFactory::convertToDto)
                .toList();
    }
}
