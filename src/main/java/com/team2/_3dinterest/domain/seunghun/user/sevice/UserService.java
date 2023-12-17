package com.team2._3dinterest.domain.seunghun.service;

import com.team2._3dinterest.domain.seunghun.repository.UserRepository;
import com.team2._3dinterest.domain.seunghun.user.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity create(String username, String email, String password) {
        UserEntity user = UserEntity.builder()
                .userName(username)
                .userEmail(email)
                .userPassword(passwordEncoder.encode(password))
                // 추가 필드에 대한 설정도 필요하다면 여기에 추가
                .build();
        this.userRepository.save(user);
        return user;
    }
}
