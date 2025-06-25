package com.practice.memberproject_fileupload.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.eclipse.tags.shaded.org.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.memberproject_fileupload.domain.Item;
import com.practice.memberproject_fileupload.service.ItemMapperService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemMapperService itemService;

    // 저장 장소 경로 선언
    @Value("${upload.path}")
    private String uploadPath;

    // 자료 리스트 화면
    @GetMapping("/list")
    public String list(Model model) throws Exception{
        log.info("[GET] /list → list 화면입니다.");
        List<Item> itemList = itemService.list();
        model.addAttribute("itemList", itemList);
        return "item/list";
    }

    // 자료 입력 화면
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/register";
    }

    @PostMapping("/register")
    public String register(Item item, Model model) {
        MultipartFile file = item.getPicture();
        log.info("originalName: " + file.getOriginalFilename());
        log.info("size: " + file.getSize());
        log.info("contentType: " + file.getContentType());

        

        
        return null;
    }
    
    // 컨트롤러 구현에 사용되는 메소드

    //파일 업로드
    private String uploadFile(String originalName, byte[] fileData) throws Exception{
        UUID uid = UUID.randomUUID();
        String createdFileName = uid.toString() + "_" + originalName;

        File target = new File(uploadPath, createdFileName);
        FileCopyUtils.copy(fileData, target);

        return createdFileName;
    }

    // 파일 삭제 (외부저장소)
    private boolean deleteFile(String fileName) throws Exception{
        if(fileName.contains("..")) {
            throw new IllegalArgumentException("잘못된 경로입니다.");
        }
        File file = new File(uploadPath, fileName);

        return (file.exists() == true) ? (file.delete()) : (false);
    }
    
    
}
