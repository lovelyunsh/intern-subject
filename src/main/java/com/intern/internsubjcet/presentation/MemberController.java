package com.intern.internsubjcet.presentation;


import com.intern.internsubjcet.application.MemberService;
import com.intern.internsubjcet.presentation.dto.request.LoginRequest;
import com.intern.internsubjcet.presentation.dto.request.RegisterRequest;
import com.intern.internsubjcet.presentation.dto.response.MemberInfoResponse;
import com.intern.internsubjcet.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/sign")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        TokenResponse response = memberService.login(request);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @GetMapping("/info/{username}")
    public ResponseEntity<MemberInfoResponse> getMemberInfo(@PathVariable String username) {
        MemberInfoResponse memberInfo = memberService.getMemberInfo(username);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberInfo);
    }

}
