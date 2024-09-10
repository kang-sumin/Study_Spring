package com.standard.sparta.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private Integer memberCnt;
}
