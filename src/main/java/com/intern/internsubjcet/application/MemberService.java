package com.intern.internsubjcet.application;

import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.request.LoginRequest;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;
import com.intern.internsubjcet.presentation.dto.response.TokenResponse;

public interface MemberService {

    MemberInfoResponse register(RegisterRequest registerRequest);

    MemberInfoResponse getMemberInfo(String username);

    TokenResponse login(LoginRequest loginRequest);



}
