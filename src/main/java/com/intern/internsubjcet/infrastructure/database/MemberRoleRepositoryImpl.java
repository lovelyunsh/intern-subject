package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import com.intern.internsubjcet.domain.repository.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
class MemberRoleRepositoryImpl implements MemberRoleRepository {
    private final MemberRoleJpaRepository memberRoleJpaRepository;

    @Override
    public Optional<MemberRole> findByMember(Member member) {
        return memberRoleJpaRepository.findByMember(member);
    }

}
