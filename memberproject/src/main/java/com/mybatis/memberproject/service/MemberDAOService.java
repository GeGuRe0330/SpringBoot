package com.mybatis.memberproject.service;

import java.util.List;



import com.mybatis.memberproject.domain.Member;
import com.mybatis.memberproject.domain.MemberAuth;
import com.mybatis.memberproject.domain.MemberEmail;


public interface MemberDAOService {
    // 회원 정보 생성
    public void insert(Member member) throws Exception;

    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception;

    // 회원 이메일 삽입
    public void insertEmail(MemberEmail MemberEmail) throws Exception;

    // 회원정보 출력 ( Member 테이블만 )
    public List<Member> selectAll() throws Exception;

    // 회원정보 전체 출력 ( Join 쿼리문을 이용하여 Member, Auth, Email 테이블을 전부 가져옴 )
    public Member selectJoin(Member member) throws Exception;

    // 회원 정보 수정
    public void update(Member member) throws Exception;

    // 회원 정보 삭제 ( 다른 테이블은 Foreing key로 지정했기 때문에 자동으로 일괄 삭제 )
    public void delete(Member member) throws Exception;

    // 회원 권한 정보 삭제
    public void deleteAuth(Member member) throws Exception;

    // 회원 이메일 정보 삭제
    public void deleteEmail(Member member) throws Exception;
}
