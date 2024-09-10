package com.standard.sparta.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 회원 DTO
 */
@Getter
@AllArgsConstructor
public class MemberDto {
    private Long memberId;
    private String name;
    private String courseName;
}
