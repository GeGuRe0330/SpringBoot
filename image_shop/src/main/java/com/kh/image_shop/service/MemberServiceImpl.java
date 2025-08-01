package com.kh.image_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.image_shop.domain.Member;
import com.kh.image_shop.domain.MemberAuth;
import com.kh.image_shop.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Override
    @Transactional
    public void register(Member member) throws Exception {
        mapper.create(member);
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");
        mapper.createAuth(memberAuth);
    }

    @Override
    public void modify(Member member) throws Exception {
        mapper.update(member);
        // 회원권한 수정
        int userNo = member.getUserNo();
        // 회원권한 삭제
        mapper.deleteAuth(userNo);
        List<MemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) {
            MemberAuth memberAuth = authList.get(i);
            String auth = memberAuth.getAuth();
            if (auth == null) {
                continue;
            }
            if (auth.trim().length() == 0) {
                continue;
            }
            // 변경된 회원권한 추가
            memberAuth.setUserNo(userNo);
            mapper.modifyAuth(memberAuth);
        }
    }

    @Override
    public List<Member> list() throws Exception {
        return mapper.list();
    }

    @Override
    public Member read(int userNo) throws Exception {
        return mapper.read(userNo);
    }

    @Override
    public void remove(int userNo) throws Exception {
        mapper.deleteAuth(userNo);
        mapper.delete(userNo);
    }

    @Override
    public int countAll() throws Exception {
        return mapper.countAll();
    }

    @Override
    public void setupAdmin(Member member) throws Exception {
        mapper.create(member);
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setUserNo(member.getUserNo());
        memberAuth.setAuth("ROLE_ADMIN");
        mapper.createAuth(memberAuth);
    }
}
