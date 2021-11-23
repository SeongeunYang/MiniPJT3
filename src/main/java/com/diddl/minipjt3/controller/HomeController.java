package com.diddl.minipjt3.controller;

import com.diddl.minipjt3.repository.PostRepository;
import com.diddl.minipjt3.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostRepository postRepository;

    @GetMapping("/")
    public String AfterLoginHome(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            model.addAttribute("username", "Guest");
        } else{
            model.addAttribute("username", userDetails.getUsername());
        }
        model.addAttribute("posts", postRepository.findAllByOrderByCreateAtDesc());
        return "board";
    }

    //글쓰기 페이지로 이동시키기
    @GetMapping("/board/newpost")
    public String moveToNewPost(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "newpost";
    }

    //글 상세 조회 페이지로 이동
    @GetMapping("/detailpost/{id}")
    public String getPostDetail(@PathVariable Long id, Model model){
        model.addAttribute("post", postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글을 불러올 수 없습니다.")
        ));
        return "detailpost";
    }
}
