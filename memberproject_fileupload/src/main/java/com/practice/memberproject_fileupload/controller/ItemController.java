package com.practice.memberproject_fileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.memberproject_fileupload.domain.Item;
import com.practice.memberproject_fileupload.service.ItemMapperService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;



@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemMapperService itemService;

    // 저장 장소 경로 선언
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("[GET] /list → list 화면입니다.");
        List<Item> itemList = itemService.list();
        return new String();
    }
    
}
