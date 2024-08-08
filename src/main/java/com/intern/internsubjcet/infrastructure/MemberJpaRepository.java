package com.intern.internsubjcet.infrastructure;

import com.intern.internsubjcet.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
