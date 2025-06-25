package com.practice.memberproject_fileupload.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int seqId;
    private int id;
    private String name;
    private int price;
    private String description;
    // <input type = "file" />
    private MultipartFile picture;
    private String pictureUrl;
}
