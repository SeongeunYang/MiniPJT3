package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.UserInfoDto;
import com.diddl.minipjt3.security.UserDetailsImpl;
import com.diddl.minipjt3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러로 선언 -> Bean등록
@RequiredArgsConstructor //final 생성자 자동으로 해주는 어노테이션
public class UserController {
    private final UserService userService;

    // 로그인 페이지 요청 시
    @GetMapping("/user/login")
    public String login(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) { //이미 로그인 한 사용자일 경우 메인페이지로 리다이렉트
            return "prelogin";
        }
        return "login";
    }

    // 회원가입 페이지 요청 시
    @GetMapping("/user/signup")
    public String signup(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {//이미 로그인 한 사용자일 경우 메인페이지로 리다이렉트
            return "prelogin";
        }
        return "signup";
    }

    // 회원가입 요청 시
    @PostMapping("/user/signup")
    @ResponseBody
    public String registerUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.registerUser(userInfoDto);
    }
}
