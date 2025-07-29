package com.kh.image_shop.controller;

import com.kh.image_shop.common.security.domain.CustomUser;
import com.kh.image_shop.domain.Board;
import com.kh.image_shop.domain.Member;
import com.kh.image_shop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    // 게시글 등록 페이지
    @GetMapping("/register")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String registerForm(Model model, Authentication authentication) throws Exception {
        // 로그인한 사용자 정보 획득
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Member member = customUser.getMember();
        Board board = new Board();
        // 로그인한 사용자 아이디를 등록 페이지에 표시
        board.setWriter(member.getUserId());
        model.addAttribute("board", board);
        return "board/register";
    }

    // 게시글 등록 처리
    @PostMapping("/register")
    public String register(Board board, RedirectAttributes rttr) throws Exception {
        service.register(board);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/board/list";
    }
}
