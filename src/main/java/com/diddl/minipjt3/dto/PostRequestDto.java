package com.diddl.minipjt3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 변수들 생성할때 쓰는거
public class PostRequestDto {
    private final String title;
    private final String author;
    private final String content;
}
