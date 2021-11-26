package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.model.Post;
import com.diddl.minipjt3.repository.CommentRepository;
import com.diddl.minipjt3.repository.PostRepository;
import com.diddl.minipjt3.security.UserDetailsImpl;
import com.diddl.minipjt3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final BoardService boardService;

    @GetMapping("/")
    public String AfterLoginHome(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            model.addAttribute("username", "Guest");
        } else {
            model.addAttribute("username", userDetails.getUsername());
        }
        model.addAttribute("posts", postRepository.findAllByOrderByCreateAtDesc());
        return "board";
    }

    //글쓰기 페이지로 이동시키기
    @GetMapping("/board/newpost")
    public String moveToNewPost(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            return "needlogin";
        }
        model.addAttribute("username", userDetails.getUsername());
        return "newpost";
    }

    //글 상세 조회 페이지로 이동
    @GetMapping("/detailpost/{id}")
    public String getPostDetail(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            model.addAttribute("username", "Guest");
        } else {
            model.addAttribute("username", userDetails.getUsername());
        }
        model.addAttribute("post", postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글을 불러올 수 없습니다.")
        ));
        model.addAttribute("comments", commentRepository.findAllByPostidOrderByCreateAtDesc(id));

        return "detailpost";
    }

    // 검색어와 일치하는 글만 보여주기
    @GetMapping("/board/search")
    public String searchPost(@RequestParam(value = "keyword") String keyword, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<Post> postDtoList = boardService.searchPosts(keyword);
        model.addAttribute("posts", postDtoList);
        if (userDetails == null) {
            model.addAttribute("username", "Guest");
        } else {
            model.addAttribute("username", userDetails.getUsername());
        }

        return "board";
    }
}