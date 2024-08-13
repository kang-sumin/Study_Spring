package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();
    private final ResourceUrlProvider mvcResourceUrlProvider;

    public MemoController(ResourceUrlProvider mvcResourceUrlProvider) {
        this.mvcResourceUrlProvider = mvcResourceUrlProvider;
    }

    // 메모 생성하기
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // Memo Max ID Check : 고유 ID를 주기 위해 자동 증가
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;

        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    // 메모 조회하기
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        //Map -> List
        List<MemoResponseDto> responseList = memoList.values().stream().map(MemoResponseDto::new).toList();

        return responseList;
    }

    // 메모 변경하기
    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if (memoList.containsKey(id)) {
            //해당 메모 객체 가져오기
            Memo memo = memoList.get(id);

            //memo 수정하기
            memo.update(requestDto);

            return memo.getId();
        } else {
            throw new IllegalArgumentException("해당 메모는 존재하지 않습니다.");
        }
    }

    // 메모 삭제하기
    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        if (memoList.containsKey(id)) {
            memoList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("해당 메모는 존재하지 않습니다.");
        }
    }


}
