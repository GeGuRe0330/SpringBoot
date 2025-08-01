package com.kh.image_shop.service;

import java.util.List;

import com.kh.image_shop.domain.CodeDetail;

public interface CodeDetailService {

    // 등록처리
    public void register(CodeDetail codeDetail) throws Exception;
    // 목록페이지
    public List<CodeDetail> list() throws Exception;
    // 상세 페이지
    public CodeDetail read(CodeDetail codeDetail) throws Exception;
    // 수정 처리
    public void modify(CodeDetail codeDetail) throws Exception;
    // 삭제 처리
    public void remove(CodeDetail codeDetail) throws Exception;

}
