package com.diddl.minipjt3.model;

import com.diddl.minipjt3.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get함수일괄 생성
@NoArgsConstructor //기본 생성자
@Entity // 엔티티 선언
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    public Post(PostRequestDto requestDto, String username) {
        this.title = requestDto.getTitle();
        this.author = username;
        this.content = requestDto.getContent();
    }
}
