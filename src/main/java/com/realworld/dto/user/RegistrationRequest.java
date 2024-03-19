package com.realworld.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.realworld.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationRequest {

    private UserDto user;

    public User toEntity() {
        return User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
