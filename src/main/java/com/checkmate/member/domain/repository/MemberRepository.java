package com.checkmate.member.domain.repository;

import com.checkmate.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


// JPA
public interface MemberRepository extends JpaRepository<Member, Long> {
}
