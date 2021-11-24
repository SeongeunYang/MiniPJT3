package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.CommentRequestDto;
import com.diddl.minipjt3.model.Comment;
import com.diddl.minipjt3.repository.CommentRepository;
import com.diddl.minipjt3.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    // 댓글 저장 API
    @PostMapping("/board/comment")
    public Comment addComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        String username = userDetails.getUsername();
        Comment comment = new Comment(requestDto, username);
        return commentRepository.save(comment);
    }

    @DeleteMapping("/comment/{id}")
    public Long deleteCommet(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}