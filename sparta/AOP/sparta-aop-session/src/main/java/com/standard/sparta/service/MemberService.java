package com.standard.sparta.service;

import com.standard.sparta.domain.Course;
import com.standard.sparta.domain.Member;
import com.standard.sparta.dto.member.MemberCreateRequestDto;
import com.standard.sparta.dto.member.MemberCreateResponseDto;
import com.standard.sparta.dto.member.MemberDto;
import com.standard.sparta.dto.member.MemberListResponseDto;
import com.standard.sparta.repository.CourseRepository;
import com.standard.sparta.repository.MemberJpaRepository;
import com.standard.sparta.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final CourseRepository courseRepository;
    private final MemberJpaRepository memberRepository;

    /**
     * 회원 저장 서비스
     */
    public MemberCreateResponseDto createMember(MemberCreateRequestDto data) {

        // 조회: 수업 아이디로 수업 조회
        Optional<Course> foundCourseOptional = courseRepository.findById(data.getCourseId());
        Course foundCourse = foundCourseOptional.get();

        // 생성: 회원 엔티티
        Member newMember = Member.createNewMember(
                foundCourse,
                data.getEmail(),
                data.getName()
        );

        // 저장: 회원
        Member savedMember = memberRepository.save(newMember);

        // 반환 응답
        return new MemberCreateResponseDto(
                "created",
                201,
                savedMember.getId()
        );
    }

    /**
     * 회원 목록 조회 서비스
     */
    public MemberListResponseDto getMemberList() {

        // 조회: 회원 엔티티 목록 조회
        log.info("::: 멤버 목록 조회 :::");
        List<Member> foundMemberList = memberRepository.findAll();

        log.info("::: 멤버 DTO 변환 :::");
        // DTO 변환: 회원 엔티티 목록 -> List<MemberDto> memberListDto
        List<MemberDto> memberDtoList = foundMemberList.stream().map(member -> new MemberDto(
                member.getId(),
                member.getName(),
                member.getCourse().getName()
        )).toList();

        // 응답 반환
        return new MemberListResponseDto(
                "success",
                200,
                memberDtoList
        );
    }
}
