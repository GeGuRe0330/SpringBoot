package com.practice.member_jpa_aop2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.member_jpa_aop2.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
}
