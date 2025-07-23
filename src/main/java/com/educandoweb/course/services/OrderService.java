package com.educandoweb.course.services;

import com.educandoweb.course.dto.order.OrderResponseDTO;
import com.educandoweb.course.entities.OrderEntity;
import com.educandoweb.course.factories.OrderFactory;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderResponseDTO> findAll() {

        List<OrderEntity> orders = repository.findAll();

        return OrderFactory.convertToDto(orders);
    }

    public OrderResponseDTO findById(Long id) {

        Optional<OrderEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new ResourceNotFoundException("Order not found");
        }

        return OrderFactory.convertToDto(optionalEntity.get());
    }
}
