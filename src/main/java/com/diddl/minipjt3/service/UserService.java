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

    public String registerUser(UserInfoDto userInfoDto) {
        String username = userInfoDto.getUsername();
        String email = userInfoDto.getEmail();
        Optional<User> found = userRepository.findByUsername(username);
        Optional<User> found_e = userRepository.findByEmail(email);
        if (found.isPresent()) { // 아이디가 존재한다면 예외처리
            return "중복된 ID 입니다.";
        } else if(found_e.isPresent()){
            return "중복된 Email 입니다.";
        }

        // 패스워드 암호화 -> 패스워드가 기억하기 쉬우면 안되기 때문에 의미없는 문자열로 바꿔줘야 한다.
        String password = passwordEncoder.encode(userInfoDto.getPassword());

        User user = new User(username, password, email); // 암호화된 패스워드로 저장해야하기 때문에 이렇게 생성
        userRepository.save(user);

        return "저장되었습니다.";
    }
}