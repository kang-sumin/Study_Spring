package com.standard.sparta.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequestDto {
    private String email;
    private String name;
    private Long courseId;
}
