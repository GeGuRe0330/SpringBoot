package com.mybatis.memberproject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.memberproject.domain.Member;
import com.mybatis.memberproject.domain.MemberAuth;
import com.mybatis.memberproject.domain.MemberEmail;
import com.mybatis.memberproject.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService{

    @Autowired
    public MemberDAO memberDAO;

    

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        // 회원 등록
        memberDAO.insert(member);
        // 회원 권한 객체 생성
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        // 등록한 회원에 기본 권한 부여
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    @Transactional
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    @Transactional
    public void insertEmail(MemberEmail MemberEmail) throws Exception {
        memberDAO.insertEmail(MemberEmail);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return memberDAO.selectAll();
    }

    @Override
    public Member selectJoin(Member member) throws Exception {
        return memberDAO.selectJoin(member);
    }

    @Override
    @Transactional
    public void update(Member member) throws Exception {
        // 회원 정보 업데이트
        memberDAO.update(member);
        // 업데이트를 위해 기존 회원 권한 삭제
        memberDAO.deleteAuth(member);
        // 업데이트를 위해 기존 이메일 정보 삭제

        // 새로 업데이트된 정보 입력
        List<MemberAuth> authList = member.getAuthList();
        List<MemberEmail> emailList = member.getEmailList();
        for(MemberAuth data : authList) {
            String auth = data.getAuth();
            if(auth == null) {
                continue;
            } else if(auth.trim().length() == 0 ) {
                continue;
            }
            data.setNo(member.getNo());
            memberDAO.insertAuth(data);
        }

        for(MemberEmail data : emailList) {
            String email = data.getEmail();
            if(email == null) {
                continue;
            } else if(email.trim().length() == 0){
                continue;
            }
            data.setNo(member.getNo());
            memberDAO.insertEmail(data);
        }
    }

    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        // 외래키 제약조건으로 인한 전체 테이블 삭제됨
        memberDAO.delete(member);
    }

    @Override
    public void deleteAuth(Member member) throws Exception {
        memberDAO.deleteAuth(member);
    }

    @Override
    public void deleteEmail(Member member) throws Exception {
        memberDAO.deleteEmail(member);
    }

}
