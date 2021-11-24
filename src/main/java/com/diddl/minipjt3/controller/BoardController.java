package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.dto.PostRequestDto;
import com.diddl.minipjt3.model.Post;
import com.diddl.minipjt3.repository.CommentRepository;
import com.diddl.minipjt3.repository.PostRepository;
import com.diddl.minipjt3.security.UserDetailsImpl;
import com.diddl.minipjt3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final 생성자
@RestController
public class BoardController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final BoardService boardService;

    //게시글 작성 & 저장 API
    @PostMapping("/board/newpost")
    public Post writePost(@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        String username = userDetails.getUsername();
        Post post = new Post(requestDto, username);
        return postRepository.save(post);
    }

    //게시글 삭제 API
    @DeleteMapping("/board/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id); //게시글 삭제
        commentRepository.deleteAllByPostid(id); //해당 게시글에 해당하는 댓글들 모두 삭제
        return id;
    }

    // 검색어와 일치하는 글만 보여주기
    @RequestMapping("/board/search")
    public String searchPost(@RequestParam(value = "keyword") String keyword, Model model){
        List<Post> postDtoList = boardService.searchPosts(keyword);

        model.addAttribute("posts",postDtoList);
        return "board";
    }
}
