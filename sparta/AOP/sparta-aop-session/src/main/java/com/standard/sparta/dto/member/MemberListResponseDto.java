package com.standard.sparta.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 회원 목록 조회 응답 DTO
 */
@Getter
@AllArgsConstructor
public class MemberListResponseDto {
    private String message;
    private Integer statusCode;
    private List<MemberDto> memberDtoList;
}
