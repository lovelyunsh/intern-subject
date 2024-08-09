package com.intern.internsubjcet.presentation;


import com.intern.internsubjcet.application.MemberService;
import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberInfoResponse> register(@RequestBody RegisterRequest request) {
        MemberInfoResponse response = memberService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
