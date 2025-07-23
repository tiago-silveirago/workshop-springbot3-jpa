package com.educandoweb.course.dto.orderItem;

import com.educandoweb.course.dto.product.ProductResponseDTO;

public record OrderItemResponseDTO(Integer quantity,
                                   Double price,
                                   Double SubTotal,
                                   ProductResponseDTO product) {

}
