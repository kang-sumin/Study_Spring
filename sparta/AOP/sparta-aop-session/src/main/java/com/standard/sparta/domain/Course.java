package com.standard.sparta.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "course")
public class Course {

    // 기본 생성자
    protected Course() {}

    // PK: 수업 아이디
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    // 수업 이름
    @Column(nullable = false, length = 20)
    private String name;

    // 삭제 여부
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    // 양방향 연관관계
    @OneToMany(mappedBy = "course")
    private List<Member> members = new ArrayList<>();

    /**
     * 초기 엔티티 생성
     */
    public static Course createNewCourse(String name) {
        Course course = new Course();
        course.name = name;
        return course;
    }
}
