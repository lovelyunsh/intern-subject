package com.intern.internsubjcet.domain.repository;

import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.type.RoleType;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByRoleType(RoleType roleType);
}
