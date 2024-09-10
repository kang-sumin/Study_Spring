package com.standard.sparta.controller;

import com.standard.sparta.dto.member.MemberCreateRequestDto;
import com.standard.sparta.dto.member.MemberCreateResponseDto;
import com.standard.sparta.dto.member.MemberListResponseDto;
import com.standard.sparta.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 생성 API
     */
    @PostMapping
    public MemberCreateResponseDto memberCreateAPI(@RequestBody MemberCreateRequestDto request) {
        return memberService.createMember(request);
    }

    /**
     * 회원 조회 API
     */
    @GetMapping
    public MemberListResponseDto memberListAPI() {
        return memberService.getMemberList();
    }
}
