package com.educandoweb.course.services;

import com.educandoweb.course.dto.product.ProductResponseDTO;
import com.educandoweb.course.entities.ProductEntity;
import com.educandoweb.course.factories.ProductFactory;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> findAll() {

        List<ProductEntity> products = repository.findAll();

        return ProductFactory.convertToDto(products);
    }

    public ProductResponseDTO findById(Long id) {

        Optional<ProductEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }

        return ProductFactory.convertToDto(optionalEntity.get());
    }
}
