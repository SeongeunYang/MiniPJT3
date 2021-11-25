package com.diddl.minipjt3.model;

import com.diddl.minipjt3.validator.UserInfoValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동으로 해주는 어노테이션
@Entity // DB에서 테이블 역할
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동으로 인덱스 증가하면서 id 생성
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private Long kakaoId;

    public User(String username, String password, String email) {
        // 회원가입 정보 유효성 검사
        UserInfoValidator.validateUserInfoInput(username, password, email);

        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.kakaoId = kakaoId;
    }
}
