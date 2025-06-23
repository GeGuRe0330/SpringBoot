package com.practice.member_jpa_aop2.service;


import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.member_jpa_aop2.domain.Member;
import com.practice.member_jpa_aop2.persistence.MemberRepository;



@Service
public class MemberDAOServiceImpl implements MemberDAOService{

    @Autowired
    private MemberRepository mr;

    @Override
    public void insert(Member member) throws Exception {
        mr.save(member);
    }

    @Override
    public Member select(Member member) throws Exception {
        return mr.getReferenceById(member.getNo());
    }

    @Override
    @Transactional
    public void update(Member member) throws Exception {
        Member memberEntity = mr.getReferenceById(member.getNo());

        memberEntity.setId(member.getId());
        memberEntity.setPw(member.getPw());
        memberEntity.setName(member.getName());
        memberEntity.setCoin(member.getCoin());
        memberEntity.setId(member.getId());
        memberEntity.setUpdDate(member.getUpdDate());

    }

    @Override
    public void delete(Member member) throws Exception {
        mr.deleteById(member.getNo());
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return mr.findAll(Sort.by(Direction.DESC, "no"));
    }
    
}
