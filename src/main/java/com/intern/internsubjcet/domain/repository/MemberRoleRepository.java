package com.intern.internsubjcet.domain.repository;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;

import java.util.Optional;

public interface MemberRoleRepository {
    Optional<MemberRole> findByMember(Member member);
}
