package com.educandoweb.course.factories;

import com.educandoweb.course.dto.orderItem.OrderItemResponseDTO;
import com.educandoweb.course.entities.OrderItemEntity;

import java.util.List;

public class OrderItemFactory {

    private OrderItemFactory() {
    }

    public static OrderItemResponseDTO convertToDto(OrderItemEntity item) {

        return new OrderItemResponseDTO(
                item.getQuantity(),
                item.getPrice(),
                item.getSubTotal(),
                ProductFactory.convertToDto(item.getProduct()));
    }

    public static List<OrderItemResponseDTO> convertToDto(List<OrderItemEntity> items) {

        return items.stream()
                .map(OrderItemFactory::convertToDto)
                .toList();
    }
}
