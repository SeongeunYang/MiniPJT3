package com.diddl.minipjt3.service;

import com.diddl.minipjt3.dto.CommentRequestDto;
import com.diddl.minipjt3.model.Comment;
import com.diddl.minipjt3.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void updateComment(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );
        comment.update(requestDto);
    }
}
