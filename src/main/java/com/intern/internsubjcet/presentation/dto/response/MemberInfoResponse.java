package com.intern.internsubjcet.presentation.dto.response;

import com.intern.internsubjcet.domain.model.Member;
import lombok.Builder;

import java.util.Set;

@Builder
public record MemberInfoResponse(
        String username,
        String nickname,
        Set<AuthorityResponse> authorities
) {

    public static MemberInfoResponse from(Member member, Set<AuthorityResponse> authorities) {
        return MemberInfoResponse.builder()
                .username(member.getUsername())
                .nickname(member.getNickname())
                .authorities(authorities).build();
    }

}
