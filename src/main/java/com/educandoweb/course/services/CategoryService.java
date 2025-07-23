package com.educandoweb.course.services;

import com.educandoweb.course.dto.category.CategoryResponseDTO;
import com.educandoweb.course.entities.CategoryEntity;
import com.educandoweb.course.entities.OrderEntity;
import com.educandoweb.course.factories.CategoryFactory;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryResponseDTO> findAll() {

        List<CategoryEntity> categories = repository.findAll();

        return CategoryFactory.convertToDto(categories);
    }

    public CategoryResponseDTO findById(Long id) {

        Optional<CategoryEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new ResourceNotFoundException("Category not found");
        }

        return CategoryFactory.convertToDto(optionalEntity.get());
    }
}
