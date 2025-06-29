package com.kh.image_shop.mapper;

import java.util.List;

import com.kh.image_shop.domain.CodeLabelValue;

public interface CodeMapper {

    // 그룹코드 목록 조회
    List<CodeLabelValue> getCodeGroupList() throws Exception;

}
