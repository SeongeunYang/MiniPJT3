package com.diddl.minipjt3.repository;

import com.diddl.minipjt3.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 하나의 글에 있는 댓글들 찾기
    List<Comment> findAllByPostidOrderByCreateAtDesc(Long postid);

    //글 삭제 시 댓글도 모두 삭제
    Long deleteAllByPostid(Long postid);
}