package com.intern.internsubjcet.domain.repository;

import com.intern.internsubjcet.domain.model.Member;

import java.util.Optional;

public interface MemberRepository {
    Member register(Member member);

    Optional<Member> findByUsername(String username);

    Optional<Member> findById(Long id);
}
