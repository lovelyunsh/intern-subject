package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsernameAndPassword(String username, String password);
}
