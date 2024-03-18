package com.realworld.service;

import com.realworld.dto.user.RegistrationRequest;
import com.realworld.model.User;
import com.realworld.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(RegistrationRequest request) {
        User user = request.toEntity();
        user.encodePassword(passwordEncoder);
        return userRepository.save(user);
    }

}
