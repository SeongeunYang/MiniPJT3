package com.diddl.minipjt3.repository;

import com.diddl.minipjt3.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreateAtDesc(); //내림차순 정렬을 위해 JPA Query작성

    List<Post> findByTitleContaining(String keyword);
}
