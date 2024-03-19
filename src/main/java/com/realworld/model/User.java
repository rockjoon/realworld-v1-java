package com.realworld.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Table(name = "'user'")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Builder
    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 32, nullable = false, unique = true)
    private String email;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @Column(length = 500)
    private String bio;

    @Column(length = 255)
    private String image;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        passwordEncoder.encode(this.password);
    }

}
