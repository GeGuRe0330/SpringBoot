package com.practice.member_jpa_aop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.member_jpa_aop.domain.Member;
import com.practice.member_jpa_aop.domain.MemberAuth;

@Repository
public interface MemberAuthRepository extends JpaRepository<MemberAuth, Integer>{
    void deleteByMember(Member member);
}
