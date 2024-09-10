//package com.standard.sparta;
//
//import com.standard.sparta.domain.Course;
//import com.standard.sparta.domain.Member;
//import com.standard.sparta.repository.CourseRepository;
//import com.standard.sparta.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    private final CourseRepository courseRepository;
//    private final MemberRepository memberRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Course javaCourse = Course.createNewCourse("Java");
//        Course springCourse = Course.createNewCourse("Spring");
//        Course reactCourse = Course.createNewCourse("React");
//        List<Course> courses = List.of(javaCourse, springCourse, reactCourse);
//        courseRepository.saveAll(courses);
//
//        Member newMember01 = Member.createNewMember(javaCourse, "member01@example.com", "member01");
//        Member newMember02 = Member.createNewMember(javaCourse, "member02@example.com", "member02");
//        Member newMember03 = Member.createNewMember(javaCourse, "member03@example.com", "member03");
//
//        Member newMember04 = Member.createNewMember(springCourse, "member04@example.com", "member04");
//        Member newMember05 = Member.createNewMember(springCourse, "member05@example.com", "member05");
//
//        Member newMember06 = Member.createNewMember(reactCourse, "member06@example.com", "member06");
//
//        List<Member> members = List.of(newMember01, newMember02, newMember03, newMember04, newMember05, newMember06);
//        memberRepository.saveAll(members);
//    }
//}
