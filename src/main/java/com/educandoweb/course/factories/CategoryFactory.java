package com.educandoweb.course.factories;

import com.educandoweb.course.dto.category.CategoryResponseDTO;
import com.educandoweb.course.entities.CategoryEntity;

import java.util.List;

public class CategoryFactory {

    private CategoryFactory() {
    }

    public static CategoryResponseDTO convertToDto(CategoryEntity category) {
        return new CategoryResponseDTO(category.getName());
    }

    public static List<CategoryResponseDTO> convertToDto(List<CategoryEntity> categories) {

        return categories.stream()
                .map(CategoryFactory::convertToDto)
                .toList();
    }
}
