package com.diddl.minipjt3.model;

import com.diddl.minipjt3.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get함수일괄 생성
@NoArgsConstructor //기본 생성자
@Entity // 엔티티 선언
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id; //댓글 ID

    @Column(nullable = false)
    private Long postid; // 게시글 번호

    @Column(nullable = false)
    private String writer; // 글쓴이

    @Column(nullable = false)
    private String content; // 댓글 내용

    public Comment(CommentRequestDto requestDto, String username) {
        this.postid = requestDto.getPostid();
        this.writer = username;
        this.content = requestDto.getContent();
    }
}
