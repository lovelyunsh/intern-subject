package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member register(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public Optional<Member> findByUsernameAndPassword(String username, String password) {
        return memberJpaRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberJpaRepository.findById(id);
    }
}
