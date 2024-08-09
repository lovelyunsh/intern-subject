package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface RoleJpaRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}
