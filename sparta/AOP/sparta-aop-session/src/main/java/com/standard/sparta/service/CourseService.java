package com.standard.sparta.service;

import com.standard.sparta.annotation.TrackTime;
import com.standard.sparta.domain.Course;
import com.standard.sparta.dto.course.CourseCreateRequestDto;
import com.standard.sparta.dto.course.CourseCreateResponseDto;
import com.standard.sparta.dto.course.CourseDto;
import com.standard.sparta.dto.course.CourseListResponseDto;
import com.standard.sparta.exception.DuplicateCourseNameException;
import com.standard.sparta.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    /**
     * 수업 생성 서비스
     */
    public CourseCreateResponseDto createCourse(CourseCreateRequestDto data) {

        // 검증: 수업 이름이 중복은 허용 안하겠다.
        boolean flag = courseRepository.existsByNameAndIsDeleted(data.getName(), false);
        if (flag) {
            throw new DuplicateCourseNameException();
        }

        // 생성: 수업(course) 엔티티
        Course newCourse = Course.createNewCourse(data.getName());

        // 저장: 코스 저장
        Course savedCourse = courseRepository.save(newCourse);

        // 응답 반환
        return new CourseCreateResponseDto(savedCourse.getId());
    }

    /**
     * 수업 목록 조회 서비스
     */
    @TrackTime
    public CourseListResponseDto getCourseList() {

//        // 측정 시작
//        long startTime = System.currentTimeMillis();

        try{
            // 조회: 수업 엔티티 목록 조회
            log.info("::: 수업 목록 조회 :::");
            List<Course> foundCourseList = courseRepository.findAll(); // 조회 쿼리 1 발생

            // DTO 변환: 수업 엔티티 -> CourseDto
            log.info("::: DTO 변환 - Course -> CourseDto :::");
            List<CourseDto> courseDtoList = foundCourseList.stream().map(course -> new CourseDto(
                    course.getId(),
                    course.getName(),
                    course.getMembers().size()
            )).toList();

            // 응답 반환
            return new CourseListResponseDto(courseDtoList);
        }finally{
//            // 측정 완료
//            long endTime = System.currentTimeMillis();
//            long excutionTime = endTime - startTime;
//            log.info("::: ExcutionTime: {}ms", excutionTime);
        }


    }
}
