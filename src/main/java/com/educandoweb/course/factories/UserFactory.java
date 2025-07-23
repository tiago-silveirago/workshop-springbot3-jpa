package com.educandoweb.course.factories;

import com.educandoweb.course.dto.user.UserRequestDTO;
import com.educandoweb.course.dto.user.UserResponseDTO;
import com.educandoweb.course.entities.UserEntity;

import java.util.List;

public class UserFactory {

    private UserFactory() {
    }

    public static UserEntity fromRequest(UserRequestDTO request) {
        return new UserEntity(request.name(), request.email(), request.phone(), request.password());
    }

    public static UserEntity fromResponse(UserResponseDTO response) {
        return new UserEntity(response.name(), response.email(), response.phone());
    }


    public static UserResponseDTO convertToDto(UserEntity user) {
        return new UserResponseDTO(user.getName(), user.getEmail(), user.getPhone());
    }


    public static List<UserResponseDTO> convertToDto(List<UserEntity> users) {

        return users.stream()
                .map(UserFactory::convertToDto)
                .toList();
    }
}
