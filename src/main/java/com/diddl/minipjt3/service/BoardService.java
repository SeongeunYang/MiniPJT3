package com.diddl.minipjt3.service;

import com.diddl.minipjt3.model.Post;
import com.diddl.minipjt3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final PostRepository postRepository;
    @Transactional
    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }
}
