package com.kh.mybatis.service;

import java.util.List;

import com.kh.mybatis.domain.MyBatisMember;


public interface MemberDAOService {

    // 게시판 삽입
    void insert(MyBatisMember member) throws Exception;

    // 게시판 출력(one)
    MyBatisMember select(MyBatisMember member) throws Exception;

    // 게시판 수정
    void update(MyBatisMember member) throws Exception;

    // 게시판 삭제
    void delete(MyBatisMember member) throws Exception;

    // 게시판 출력(All 전체)
    List<MyBatisMember> selectAll() throws Exception;

}