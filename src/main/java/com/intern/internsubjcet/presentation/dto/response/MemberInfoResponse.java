package com.intern.internsubjcet.presentation.dto.response;

import java.util.Set;

public record MemberInfoResponse(
        String username,
        String nickname,
        Set<AuthorityResponse> authorities
) {

}
