package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.UserInfoDto;
import com.diddl.minipjt3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러로 선언 -> Bean등록
@RequiredArgsConstructor //final 생성자 자동으로 해주는 어노테이션
public class UserController {
    private final UserService userService;

    // 로그인 페이지 요청 시
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원가입 페이지 요청 시
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원가입 요청 시
    @PostMapping("/user/signup")
    public String registerUser(UserInfoDto userInfoDto) {
        userService.registerUser(userInfoDto);
        return "redirect:/user/login";
    }
}
