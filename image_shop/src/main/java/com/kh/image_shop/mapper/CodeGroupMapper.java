package com.kh.image_shop.mapper;

import java.util.List;

import com.kh.image_shop.domain.CodeGroup;

public interface CodeGroupMapper {

    // 등록처리
    public void create(CodeGroup codeGroup) throws Exception;
    // 목록 페이지
    public List<CodeGroup> list() throws Exception;
    // 상세 페이지
    public CodeGroup read(String groupCode) throws Exception;
    // 수정 처리
    public void update(CodeGroup codeGroup) throws Exception;
    // 삭제 처리
    public void delete(CodeGroup codeGroup) throws Exception;
}