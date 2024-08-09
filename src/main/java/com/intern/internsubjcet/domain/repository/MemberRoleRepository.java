package com.intern.internsubjcet.domain.repository;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;

import java.util.List;

public interface MemberRoleRepository {
    MemberRole save(MemberRole memberRole);

    List<MemberRole> findByMember(Member member);
}
