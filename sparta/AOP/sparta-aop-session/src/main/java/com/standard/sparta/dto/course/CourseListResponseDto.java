package com.standard.sparta.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 수업 목록 조회 응답 DTO
 */
@Getter
@AllArgsConstructor
public class CourseListResponseDto {
//    private String message;
//    private Integer statusCode;
    List<CourseDto> courseDtoList;
}
