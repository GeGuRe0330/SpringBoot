package com.practice.member_jpa_aop.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.member_jpa_aop.domain.Member;
import com.practice.member_jpa_aop.domain.MemberAuth;
import com.practice.member_jpa_aop.domain.MemberEmail;
import com.practice.member_jpa_aop.persistence.MemberAuthRepository;
import com.practice.member_jpa_aop.persistence.MemberEmailRepository;
import com.practice.member_jpa_aop.persistence.MemberRepository;

@Service
public class MemberDAOServiceImpl implements MemberDAOService{

    @Autowired
    public MemberRepository mr;
    public MemberAuthRepository ar;
    public MemberEmailRepository er;
    

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        // 회원 등록
        mr.save(member);
        // 회원 권한 객체 생성
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setMember(member);
        memberAuth.setAuth("ROLE_USER");
        // 등록한 회원에 기본 권한 부여
        ar.save(memberAuth);
    }

    @Override
    @Transactional
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        ar.save(memberAuth);
    }

    @Override
    @Transactional
    public void insertEmail(MemberEmail memberEmail) throws Exception {
        er.save(memberEmail);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return mr.findAll(Sort.by(Direction.DESC, "no"));
    }

    @Override
    public Member selectJoin(Member member) throws Exception {
        return mr.findById(member.getNo())
             .orElseThrow(() -> new Exception("회원 정보가 존재하지 않습니다."));

    }

@Override
@Transactional
public void update(Member member) throws Exception {
    // 1. 기존 회원을 영속 상태로 조회
    Member persisted = mr.findById(member.getNo())
        .orElseThrow(() -> new Exception("존재하지 않는 회원입니다."));

    // 2. 회원 기본 정보 업데이트
    persisted.setId(member.getId());
    persisted.setPw(member.getPw());
    persisted.setName(member.getName());
    persisted.setCoin(member.getCoin());
    persisted.setUpdDate(new Date());
    persisted.setEnabled(member.getEnabled());

    // 3. 기존 권한/이메일 삭제
    persisted.getAuthList().clear();
    persisted.getEmailList().clear();

    // 4. 새로운 권한 추가
    for (MemberAuth data : member.getAuthList()) {
        if (data.getAuth() != null && !data.getAuth().trim().isEmpty()) {
            data.setMember(persisted); // 관계 설정
            persisted.getAuthList().add(data);
        }
    }

    // 5. 새로운 이메일 추가
    for (MemberEmail data : member.getEmailList()) {
        if (data.getEmail() != null && !data.getEmail().trim().isEmpty()) {
            data.setMember(persisted);
            persisted.getEmailList().add(data);
        }
    }

    // 6. 저장은 생략 가능 (영속 상태니까 트랜잭션 커밋 시 자동 반영)
}

    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        // 외래키 제약조건으로 인한 전체 테이블 삭제됨
        mr.deleteById(member.getNo());
    }

    @Override
    public void deleteAuth(Member member) throws Exception {
        ar.deleteByMember(member);
    }

    @Override
    public void deleteEmail(Member member) throws Exception {
        er.deleteByMember(member);
    }

}
