package com.standard.sparta.repository;

import com.standard.sparta.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 순수 JPA 기반 Repository
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberJpaRepository {

    private final EntityManager entityManager;

    /**
     * 회원 저장
     */
    @Transactional
    public Member save(Member member) {
        log.info("::: 순수 JPA 기반 - save() :::");
        entityManager.persist(member);
        return member;
    }

    /**
     * 회원 목록 조회
     */
    public List<Member> findAll() {
        log.info("::: 순수 JPA 기반 - findAll() :::");
        String jpql = "SELECT m FROM Member m";
        return entityManager
                .createQuery(jpql, Member.class)
                .getResultList();
    }
}
