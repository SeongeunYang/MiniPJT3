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
    @PostMapping("/detailpost/comment")
    @ResponseBody
    public String addComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            return "회원이 아닙니다.";
        }
        String username = userDetails.getUsername();
        Comment comment = new Comment(requestDto, username);
        commentRepository.save(comment);
        return "save";
    }

    // 댓글 수정 API
    @PutMapping("/comment/{id}")
    @ResponseBody
    public String updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(id, requestDto);
        return "save";
    }

    // 댓글 삭제 API
    @DeleteMapping("/comment/{id}")
    @ResponseBody
    public Long deleteCommet(@PathVariable Long id) {
        commentRepository.deleteById(id); // 해당 댓글 삭제하기
        return id;
    }
}