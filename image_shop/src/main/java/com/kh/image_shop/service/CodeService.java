package com.kh.image_shop.service;

import java.util.List;

import com.kh.image_shop.domain.CodeLabelValue;

public interface CodeService {
    // 그룹코드 목록 조회
    public List<CodeLabelValue> getCodeGroupList() throws Exception;

    // 지정된 그룹코드에 해당하는 코드 목록 조회
    public List<CodeLabelValue> getCodeList(String groupCode) throws Exception;

}
