package com.educandoweb.course.services;

import com.educandoweb.course.dto.user.UserRequestDTO;
import com.educandoweb.course.dto.user.UserResponseDTO;
import com.educandoweb.course.entities.UserEntity;
import com.educandoweb.course.factories.UserFactory;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exeptions.EntityInUseException;
import com.educandoweb.course.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.educandoweb.course.factories.UserFactory.convertToDto;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {

        List<UserEntity> users = repository.findAll();

        return convertToDto(users);
    }

    public UserResponseDTO findById(Long id) {

        Optional<UserEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }

        return UserFactory.convertToDto(optionalEntity.get());
    }

    public UserResponseDTO insert(UserRequestDTO request) {

        UserEntity entity = UserFactory.fromRequest(request);
        UserEntity savedEntity = repository.save(entity);

        return UserFactory.convertToDto(savedEntity);
    }

    public void delete(Long id) {

        UserEntity entity = UserFactory.fromResponse(findById(id));

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("Invalid action. User is linked to one or more orders.");
        }
    }

    public UserResponseDTO update(Long id, UserRequestDTO request) {

        UserFactory.fromResponse(findById(id));

        UserEntity entity = repository.getReferenceById(id);
        updateData(entity, request);
        UserEntity savedUser = repository.save(entity);

        return new UserResponseDTO(savedUser.getName(), savedUser.getEmail(), savedUser.getPhone());
    }

    private void updateData(UserEntity entity, UserRequestDTO request) {

        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPhone(request.phone());
    }
}
