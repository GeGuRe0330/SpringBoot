package com.practice.member_jpa_aop2.service;

import java.util.List;

import com.practice.member_jpa_aop2.domain.Member;

public interface MemberDAOService{

    // 회원 정보 생성
    void insert(Member member) throws Exception;

    // 회원정보 전체 출력 ( Join 쿼리문을 이용하여 Member, Auth, Email 테이블을 전부 가져옴 )
    Member select(Member member) throws Exception;

    // 회원 정보 수정
    void update(Member member) throws Exception;

    // 맴버 삭제
    void delete(Member member) throws Exception;

    // 회원정보 출력 ( Member 테이블만 )
    List<Member> selectAll() throws Exception;

}