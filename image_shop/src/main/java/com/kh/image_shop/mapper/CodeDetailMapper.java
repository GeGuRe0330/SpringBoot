package com.kh.image_shop.mapper;

import java.util.List;

import com.kh.image_shop.domain.CodeDetail;

public interface CodeDetailMapper {

    // 등록처리
    public void create(CodeDetail codeDetail) throws Exception;
    // 그룹코드 정렬 순서의 최대값
    public Integer getMaxSortSeq(String groupCode) throws Exception;
    // 목록페이지
    public List<CodeDetail> list() throws Exception;
    // 상세 페이지
    public CodeDetail read(CodeDetail codeDetail) throws Exception;
    // 수정 처리
    public void update(CodeDetail codeDetail) throws Exception;
    // 삭제 처리
    public void delete(CodeDetail codeDetail) throws Exception;

}
