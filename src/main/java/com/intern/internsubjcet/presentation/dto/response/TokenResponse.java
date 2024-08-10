package com.intern.internsubjcet.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenResponse {

    private String grantType; // JWT에 대한 인증 타입. 여기서는 Bearer를 사용한다. 이후 HHTP 헤더에 prefix로 붙여주는 타입
    private String accessToken;
    private String refreshToken;
}