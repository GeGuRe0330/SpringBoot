package com.practice.member_jpa_aop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.member_jpa_aop.domain.Member;
import com.practice.member_jpa_aop.domain.MemberEmail;

@Repository
public interface MemberEmailRepository extends JpaRepository<MemberEmail, Integer>{
    void deleteByMember(Member member);
}
