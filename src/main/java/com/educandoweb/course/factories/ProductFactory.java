package com.educandoweb.course.factories;

import com.educandoweb.course.dto.product.ProductResponseDTO;
import com.educandoweb.course.entities.ProductEntity;

import java.util.List;

public class ProductFactory {

    private ProductFactory() {
    }

    public static ProductResponseDTO convertToDto(ProductEntity product) {

        return new ProductResponseDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImgUrl(),
                CategoryFactory.convertToDto(product.getCategories().stream().toList()));
    }

    public static List<ProductResponseDTO> convertToDto(List<ProductEntity> products) {

        return products.stream()
                .map(ProductFactory::convertToDto)
                .toList();

    }
}

