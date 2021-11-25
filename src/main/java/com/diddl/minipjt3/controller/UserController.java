package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.UserInfoDto;
import com.diddl.minipjt3.security.UserDetailsImpl;
import com.diddl.minipjt3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String registerUser(@RequestBody UserInfoDto userInfoDto, Errors errors) {
        if (errors.hasErrors()) { // 서버단에서도 회원가입 유효성 검사 실행
            List<ObjectError> list = errors.getAllErrors();
            for (ObjectError e : list) {
                return e.getDefaultMessage(); //제일 처음 에러 내용 반환하기
            }
        }
        return userService.registerUser(userInfoDto);
    }
}
