package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRoleJpaRepository extends JpaRepository<MemberRole, Long> {

    Optional<MemberRole> findByMember(Member member);
}
