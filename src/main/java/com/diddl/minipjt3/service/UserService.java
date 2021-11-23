package com.diddl.minipjt3.service;

import com.diddl.minipjt3.dto.UserInfoDto;
import com.diddl.minipjt3.model.User;
import com.diddl.minipjt3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service //서비스로 등록 -> Bean등록
public class UserService {
    private final PasswordEncoder passwordEncoder; // 패스워드 암호화
    private final UserRepository userRepository;

    public void registerUser(UserInfoDto userInfoDto) {
        String username = userInfoDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if(found.isPresent()){ // 아이디가 존재한다면 예외처리
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화 -> 패스워드가 기억하기 쉬우면 안되기 때문에 의미없는 문자열로 바꿔줘야 한다.
        String password = passwordEncoder.encode(userInfoDto.getPassword());
        String email = userInfoDto.getEmail();

        User user = new User(username, password, email); // 암호화된 패스워드로 저장해야하기 때문에 이렇게 생성
        userRepository.save(user);
    }
}