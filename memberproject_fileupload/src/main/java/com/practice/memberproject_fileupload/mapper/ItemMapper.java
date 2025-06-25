package com.practice.memberproject_fileupload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.memberproject_fileupload.domain.Item;

@Mapper
public interface ItemMapper {
        // 파일 삽입
    public void create(Item item) throws Exception;

    // 파일 출력(One)
    public Item read(Item item) throws Exception;

    // 파일 수정
    public void update(Item item) throws Exception;

    // 파일 삭제
    public void delete(Item item) throws Exception;

    // 파일 출력 (ALL)
    public List<Item> list() throws Exception;

    // 파일 경로
    public Item getPicture(Item item) throws Exception;
}
