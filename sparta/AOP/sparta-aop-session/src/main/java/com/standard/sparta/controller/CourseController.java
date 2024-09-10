package com.standard.sparta.controller;

import com.standard.sparta.dto.ApiResponse;
import com.standard.sparta.dto.course.CourseCreateRequestDto;
import com.standard.sparta.dto.course.CourseCreateResponseDto;
import com.standard.sparta.dto.course.CourseListResponseDto;
import com.standard.sparta.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /**
     * 수업(course) 생성
     */
    @PostMapping
    public ApiResponse<CourseCreateResponseDto> createCourseAPI(@RequestBody CourseCreateRequestDto request) {
        CourseCreateResponseDto courseCreateResponseDto = courseService.createCourse(request);
        return ApiResponse.createSuccess(
                HttpStatus.CREATED.getReasonPhrase(),
                HttpStatus.CREATED.value(),
                courseCreateResponseDto
        );
    }

    /**
     * 수업(course) 목록 조회
     *
     * @return
     */
    @GetMapping
//    public ApiResponse<CourseListResponseDto> courseListAPI() {
    public ResponseEntity<Map<String, Object>> courseListAPI() {
        CourseListResponseDto courseList = courseService.getCourseList();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "메시지는 여기에");
        responseMap.put("statusCode", HttpStatus.CREATED);
        responseMap.put("body", courseList);
        return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
    }

}

















