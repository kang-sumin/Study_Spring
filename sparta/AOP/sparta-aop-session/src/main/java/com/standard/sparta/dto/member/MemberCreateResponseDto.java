package com.standard.sparta.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberCreateResponseDto {
    private String message;
    private Integer statusCode;
    private Long memberId;
}
