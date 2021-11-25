package com.diddl.minipjt3.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserInfoValidator {
    public static void validateUserInfoInput(String username, String password, String email) {
        String patternId = "^[a-zA-z0-9]{3,}$"; //아이디 패턴
        String patternEmail = "\\\\w+@\\\\w+\\\\.\\\\w+(\\\\.\\\\w+)?";

        // 아이디 형식 확인
        if (username == null || !Pattern.matches(patternId, username)) {
            throw new IllegalArgumentException("최소 3자 이상, 알파벳 대소문자, 숫자로 이루어져야 합니다.");
        }

        // 비밀번호 형식 확인
        if (password == null || password.contains(username) || password.length() < 4) {
            throw new IllegalArgumentException("최소 4자 이상, 닉네임과 같은 값이 포함되지 않아야 합니다.");
        }

//        // 이메일 형식 확인
//        if (email == null || !Pattern.matches(patternEmail, email)){
//            throw new IllegalArgumentException("이메일 형식이 아닙니다.");
//        }
    }
}
