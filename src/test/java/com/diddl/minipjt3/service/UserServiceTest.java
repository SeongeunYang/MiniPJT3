package com.diddl.minipjt3.service;

import com.diddl.minipjt3.dto.UserInfoDto;
import com.diddl.minipjt3.model.User;
import com.diddl.minipjt3.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository mockUserRepository;

    @Mock
    PasswordEncoder mockPasswordEncoder;

    @Test
    @DisplayName("ID 중복 테스트1")
    void checkIdDuplication1() {
        String username = "diddl";
        String password = "tjddms1234";
        String email = "xxx@naver.com";

        UserInfoDto userInfoDto = new UserInfoDto(
                username,
                password,
                email
        );

        User user = new User(username, password, email);
        when(mockUserRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserService userService = new UserService(mockPasswordEncoder, mockUserRepository);

        String exception = userService.registerUser(userInfoDto);

        assertEquals("중복된 ID 입니다.", exception);
    }

    @Test
    @DisplayName("ID 중복 테스트2")
    void checkIdDuplication2() {
        String username = "asdf";
        String password = "tjddms1234";
        String email = "xxx@naver.com";

        UserInfoDto userInfoDto = new UserInfoDto(
                username,
                password,
                email
        );

        User user = new User(username, password, email);
        when(mockUserRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserService userService = new UserService(mockPasswordEncoder, mockUserRepository);

        String exception = userService.registerUser(userInfoDto);

        assertEquals("중복된 ID 입니다.", exception);
    }
}