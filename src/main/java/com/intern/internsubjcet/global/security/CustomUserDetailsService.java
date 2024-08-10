package com.intern.internsubjcet.global.security;

import com.intern.internsubjcet.domain.model.Member;
import com.intern.internsubjcet.domain.model.MemberRole;
import com.intern.internsubjcet.domain.model.Role;
import com.intern.internsubjcet.domain.repository.MemberRepository;
import com.intern.internsubjcet.domain.repository.MemberRoleRepository;
import com.intern.internsubjcet.domain.type.RoleType;
import com.intern.internsubjcet.presentation.dto.response.AuthorityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(IllegalAccessError::new);
        Set<SimpleGrantedAuthority> collect = memberRoleRepository.findByMember(member).stream()
                .map(MemberRole::getRole)
                .map(Role::getRoleType)
                .map(RoleType::name)
                .map(s -> new SimpleGrantedAuthority(s))
                .collect(Collectors.toSet());

        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .authorities(collect)
                .build();
    }
}