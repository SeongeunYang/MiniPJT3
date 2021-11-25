package com.diddl.minipjt3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    @Nested
    @DisplayName("회원가입 요청, User 객체 생성")
    class CreateUserInfo {
        private String username;
        private String password;
        private String email;

        @BeforeEach
        void setup() {
            username = "diddl";
            password = "tjddms1234";
            email = "xxx@naver.com";
        }

        @Test
        @DisplayName("정상 케이스")
        void createUserInfo_Normal() {
            User user = new User(username, password, email);

            assertEquals(user.getUsername(), username);
            assertEquals(user.getPassword(), password);
            assertEquals(user.getEmail(), email);
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCases {
            @Nested
            @DisplayName("회원 ID")
            class Username {
                @Test
                @DisplayName("null")
                void fail1() {
                    username = null;

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 3자 이상, 알파벳 대소문자, 숫자로 이루어져야 합니다.", exception.getMessage());
                }

                @Test
                @DisplayName("한국어로 이루어져 있을 때")
                void fail2() {
                    username = "양성은";

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 3자 이상, 알파벳 대소문자, 숫자로 이루어져야 합니다.", exception.getMessage());
                }

                @Test
                @DisplayName("ID 길이가 부족할 때")
                void fail3() {
                    username = "se";

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 3자 이상, 알파벳 대소문자, 숫자로 이루어져야 합니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("비밀번호")
            class Password {
                @Test
                @DisplayName("null")
                void fail1() {
                    password = null;

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 4자 이상, 닉네임과 같은 값이 포함되지 않아야 합니다.", exception.getMessage());
                }

                @Test
                @DisplayName("아이디를 포함하고 있을 때")
                void fail2() {
                    password = "diddl1234";

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 4자 이상, 닉네임과 같은 값이 포함되지 않아야 합니다.", exception.getMessage());
                }

                @Test
                @DisplayName("Password 길이가 부족할 때")
                void fail3() {
                    username = "tjd";

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(username, password, email);
                    });

                    assertEquals("최소 4자 이상, 닉네임과 같은 값이 포함되지 않아야 합니다.", exception.getMessage());
                }
            }
        }
    }
}