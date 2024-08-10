package com.intern.internsubjcet.application;


import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.repository.MemberRepository;
import com.intern.internsubjcet.domain.repository.MemberRoleRepository;
import com.intern.internsubjcet.domain.repository.RoleRepository;
import com.intern.internsubjcet.domain.type.RoleType;
import com.intern.internsubjcet.global.jwt.JwtTokenProvider;
import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.request.LoginRequest;
import com.intern.internsubjcet.presentation.dto.response.AuthorityResponse;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;
import com.intern.internsubjcet.presentation.dto.response.TokenResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public MemberInfoResponse register(RegisterRequest registerRequest) {
        String encodePassword = passwordEncoder.encode(registerRequest.password());
        if(memberRepository.findByUsername(registerRequest.username()).isPresent()){
            throw new IllegalArgumentException();
        }

        Member member = memberRepository.register(registerRequest.of(encodePassword));
        MemberRole defaultMemberRole = createDefaultMemberRole(member);
        memberRoleRepository.save(defaultMemberRole);
        Set<AuthorityResponse> authorities = findAuthorities(member);

        return MemberInfoResponse.from(member, authorities);
    }

    @Override
    public MemberInfoResponse getMemberInfo(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow();
        Set<AuthorityResponse> authorities = findAuthorities(member);
        return MemberInfoResponse.from(member, authorities);
    }

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return jwtTokenProvider.generateToken(authentication);
    }


    private MemberRole createDefaultMemberRole(Member member) {
        Role role = roleRepository.findByRoleType(RoleType.ROLE_USER).orElseThrow();
        return MemberRole.builder()
                .member(member)
                .role(role)
                .build();
    }

    private Set<AuthorityResponse> findAuthorities(Member member) {
        return memberRoleRepository.findByMember(member).stream()
                .map(MemberRole::getRole)
                .map(Role::getRoleType)
                .map(RoleType::name)
                .map(AuthorityResponse::new)
                .collect(Collectors.toSet());
    }

}
