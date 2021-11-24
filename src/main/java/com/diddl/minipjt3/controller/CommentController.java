package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.CommentRequestDto;
import com.diddl.minipjt3.model.Comment;
import com.diddl.minipjt3.repository.CommentRepository;
import com.diddl.minipjt3.security.UserDetailsImpl;
import com.diddl.minipjt3.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    // 댓글 저장 API
    @PostMapping("/board/comment")
    @ResponseBody
    public String addComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails == null){
            return "not user";
        }
        String username = userDetails.getUsername();
        Comment comment = new Comment(requestDto, username);
        commentRepository.save(comment);
        return "save";
    }

    // 댓글 수정 API
    @PutMapping("/board/comment/{id}")
    @ResponseBody
    public String updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails == null){
            return "not user";
        }
        commentService.updateComment(id, requestDto);
        return "save";
    }

    @DeleteMapping("/comment/{id}")
    @ResponseBody
    public Long deleteCommet(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}