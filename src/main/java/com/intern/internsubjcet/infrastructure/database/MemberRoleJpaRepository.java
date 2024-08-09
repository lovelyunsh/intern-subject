package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface MemberRoleJpaRepository extends JpaRepository<MemberRole, Long> {

    List<MemberRole> findByMember(Member member);
}
