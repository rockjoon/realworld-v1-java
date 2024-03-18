package com.realworld.dto.user;

import com.realworld.model.User;
import lombok.Data;

@Data
public record RegistrationRequest(String email, String username, String password) {

    public User toEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .build();
    }
}
