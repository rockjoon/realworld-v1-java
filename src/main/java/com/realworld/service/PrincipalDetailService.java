package com.realworld.service;

import com.realworld.model.PrincipalDetails;
import com.realworld.model.User;
import com.realworld.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername().orElseThrow(
                () -> new UsernameNotFoundException("user name not found"));
        return new PrincipalDetails(user);
    }

}
