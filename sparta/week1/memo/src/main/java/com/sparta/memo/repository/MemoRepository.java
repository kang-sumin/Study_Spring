package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 수정 시간을 내림차순으로 가져옴
    List<Memo> findAllByOrderByModifiedAtDesc();

    // 해당 username을 가진 사람이 작성한 모든 메모 내용 가져옴
    List<Memo> findAllByUsername(String username);
}
