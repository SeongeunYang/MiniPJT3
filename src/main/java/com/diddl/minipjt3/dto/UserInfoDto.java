package com.diddl.minipjt3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@RequiredArgsConstructor // final 변수들 생성할때 쓰는거
public class UserInfoDto {
    @NotEmpty
    @Pattern(regexp="^[a-zA-z0-9]{3,}$", message = "최소 3자 이상, 알파벳 대소문자, 숫자로 이루어져야 합니다.")
    private final String  username;

    @NotEmpty
    @Pattern(regexp="^[a-zA-z0-9]{4,12}$", message = "최소 4자 이상, 닉네임과 같은 값이 포함되지 않아야 합니다.")
    private final String password;

    @Email
    private final String email;
}