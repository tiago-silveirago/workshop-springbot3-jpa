package com.educandoweb.course.dto.product;

import com.educandoweb.course.dto.category.CategoryResponseDTO;

import java.util.List;

public record ProductResponseDTO(String name,
                                 String description,
                                 Double price,
                                 String imgUrl,
                                 List<CategoryResponseDTO> categories) {

}
