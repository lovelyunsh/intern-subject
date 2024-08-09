package com.intern.internsubjcet.application;

import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;

public interface MemberService {

    MemberInfoResponse register(RegisterRequest registerRequest);

}
