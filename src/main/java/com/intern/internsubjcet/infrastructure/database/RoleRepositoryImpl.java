package com.intern.internsubjcet.infrastructure.database;

import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.repository.RoleRepository;
import com.intern.internsubjcet.domain.type.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleJpaRepository roleJpaRepository;

    @Override
    public Optional<Role> findByRoleType(RoleType roleType) {
        return roleJpaRepository.findByRoleType(roleType);
    }

}
