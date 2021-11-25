package com.diddl.minipjt3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // final 변수들 생성할때 쓰는거
public class UserInfoDto {
    private final String  username;
    private final String password;
    private final String email;
}