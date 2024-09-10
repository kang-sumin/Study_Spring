package com.standard.sparta.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Fetch;

@Getter
@Entity
@Table(name = "member")
public class Member {

    protected Member() {}

    // PK: 회원 아이디
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    // FK: 수업 (단방향 매핑)
//    @ManyToOne(fetch = FetchType.EAGER)
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // 이메일
    @Column(nullable = false, length = 200)
    private String email;

    // 이름
    @Column(nullable = false, length = 20)
    private String name;

    //삭제 여부
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    /**
     * 새로운 회원 엔티티 생성
     */
    public static Member createNewMember(Course course, String email, String name) {
        Member newMember = new Member();
        newMember.course = course;
        newMember.email = email;
        newMember.name = name;
        newMember.isDeleted = false;
        return newMember;
    }
}
