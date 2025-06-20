package com.kh.mybatis.Controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.mybatis.domain.MyBatisMember;
import com.kh.mybatis.service.MemberDAOService;

import lombok.extern.java.Log;


@Controller
@Log
@RequestMapping("/member")
@MapperScan(basePackages = "com.kh.mybatis.mapper")
public class MemberController {
    
    @Autowired
    private MemberDAOService service;

    // 게시판 입력 화면 요청
    @GetMapping(value = "/register")
    public String registerForm(MyBatisMember member, Model model) throws Exception {
        log.info("registerForm");
        model.addAttribute("member", member);
        return "member/register";
    }

    // 게시판 디비 입력 요청
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(MyBatisMember member, Model model) throws Exception {
        service.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "member/success";
    }

    // 게시판 리스트 화면 요청
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", service.selectAll());
        return "member/list";
    }

    // 게시판 상세 화면 요청
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(MyBatisMember member, Model model) throws Exception {
        model.addAttribute("member", service.select(member));
        return "member/read";
    }

    // 게시판 삭제 요청
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(MyBatisMember member, Model model) throws Exception {
        service.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 게시판 수정 화면 요청
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyForm(MyBatisMember member, Model model) throws Exception {
        model.addAttribute("member", service.select(member));
        return "member/modify";
    }

    // 게시판 수정 요청
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(MyBatisMember member, Model model) throws Exception {
        service.update(member);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "member/success";
    }
}
