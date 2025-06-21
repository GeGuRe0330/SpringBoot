package com.mybatis.memberproject.mapper;


import java.util.List;

import com.mybatis.memberproject.domain.Member;
import com.mybatis.memberproject.domain.MemberAuth;
import com.mybatis.memberproject.domain.MemberEmail;

public interface MemberDAO {
    // 회원 정보 생성
    public void insert(Member member) throws Exception;

    // 회원 권한 삽입
    public void insert(MemberAuth memberAuth) throws Exception;

    // 회원 이메일 삽입
    public void insert(MemberEmail MemberEmail) throws Exception;

    // 회원정보 출력 ( Member 테이블만 )
    // 전체 리스트를 가져오는 메소드이기에 매개변수를 필요로하지 않음 -> select * from member; 만 실행하면 되기 때문
    public List<Member> selectAll() throws Exception;

    // 회원정보 전체 출력 ( Join 쿼리문을 이용하여 Member, Auth, Email 테이블을 전부 가져옴 )
    // 검색한 한명만 출력하는 메소드이기에 리턴값을 Member로 지정
    // 검색을 위해 no 를 가져올 매개변수 Member member가 필요로 함. #{no}는 도메인에 있는 Member.java의 getNo()함수를 통해 추출해오기 때문
    public Member selectJoin(Member member) throws Exception;

    // 회원 정보 수정
    public void update(Member member) throws Exception;

    // 회원 정보 삭제 ( 다른 테이블은 Foreing key로 지정했기 때문에 자동으로 일괄 삭제 )
    public void delete(Member member) throws Exception;
}
