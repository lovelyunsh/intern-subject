package com.intern.internsubjcet.presentation.dto.request;

import com.intern.internsubjcet.domain.model.Member;

public record RegisterRequest(
        String username,
        String password,
        String nickname
) {

    public Member of() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }

}
