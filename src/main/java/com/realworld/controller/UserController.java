package com.realworld.controller;

import com.realworld.dto.user.RegistrationRequest;
import com.realworld.model.User;
import com.realworld.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> registration(RegistrationRequest request) {
        User registered = userService.signUp(request);
        return ResponseEntity.ok(registered);
    }


}
