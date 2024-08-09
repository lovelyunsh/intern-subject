package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import com.intern.internsubjcet.domain.repository.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
class MemberRoleRepositoryImpl implements MemberRoleRepository {
    private final MemberRoleJpaRepository memberRoleJpaRepository;

    @Override
    public MemberRole save(MemberRole memberRole) {
        return memberRoleJpaRepository.save(memberRole);
    }

    @Override
    public List<MemberRole> findByMember(Member member) {
        return memberRoleJpaRepository.findByMember(member);
    }

}
