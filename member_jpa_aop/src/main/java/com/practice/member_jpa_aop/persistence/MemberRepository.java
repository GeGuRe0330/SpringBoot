package com.practice.member_jpa_aop.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.member_jpa_aop.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @EntityGraph(attributePaths = { "authList", "emailList" })
    Optional<Member> findById(Integer no);
}
