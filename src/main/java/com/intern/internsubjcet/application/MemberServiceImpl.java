package com.intern.internsubjcet.application;


import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.repository.MemberRepository;
import com.intern.internsubjcet.domain.repository.MemberRoleRepository;
import com.intern.internsubjcet.domain.repository.RoleRepository;
import com.intern.internsubjcet.domain.type.RoleType;
import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.response.AuthorityResponse;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public MemberInfoResponse register(RegisterRequest registerRequest) {
        Member member = memberRepository.register(registerRequest.of());

        Role role = roleRepository.findByRoleType(RoleType.ROLE_USER).orElseThrow();

        memberRoleRepository.save(
                MemberRole.builder()
                        .member(member)
                        .role(role)
                        .build()
        );

        Set<AuthorityResponse> authorities = memberRoleRepository.findByMember(member).stream()
                .map(MemberRole::getRole)
                .map(Role::getRoleType)
                .map(RoleType::name)
                .map(AuthorityResponse::new)
                .collect(Collectors.toSet());

        return MemberInfoResponse.from(member, authorities);
    }

}
