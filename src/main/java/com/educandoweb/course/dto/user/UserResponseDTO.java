package com.educandoweb.course.dto.user;

public record UserResponseDTO(String name,
                              String email,
                              String phone,
                              String password) {

    public UserResponseDTO(String name, String email, String phone) {
        this(name, email, phone, "");
    }
}
