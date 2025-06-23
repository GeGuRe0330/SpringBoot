package com.mybatis.memberproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.memberproject.domain.Member;
import com.mybatis.memberproject.service.MemberDAOService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberDAOService service;

    // 회원가입 요청 화면
    @GetMapping(value = "/register")
    public String registerForm(Member member, Model model) throws Exception {
        log.info("UserRegisterForm");
        return "member/register";
    }

    // 회원 가입 처리요청
    @PostMapping(value = "/register")
    public String register(Member member, Model model) throws Exception {
        service.insert(member);
        model.addAttribute("msg",
                "등록이 완료되었습니다.");
        return "member/success";
    }

    // 회원 정보 전체 출력
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", service.selectAll());
        return "member/list";
    }

    // 회원 정보, 권한 출력 (조인)
    @GetMapping("/read")
    public String read(Member member, Model model) throws Exception {
        model.addAttribute("member",service.selectJoin(member));
        return "member/read";
    }

    // 회원 , 권한 삭제
    @PostMapping("/remove")
    public String remove(Member member, Model model) throws Exception {
        service.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 회원 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(Member member, Model model) throws Exception {
        model.addAttribute(service.selectJoin(member));
        return "member/modify";
    }

    // 회원 정보 수정
    @PostMapping("/modify")
    public String modify(Member member, Model model) throws Exception {
        service.update(member);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "member/success";
    }
}
