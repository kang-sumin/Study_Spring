package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final JdbcTemplate jdbcTemplate;

    public MemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // 객체간 이동을 위해 MemoService 객체 생성
        MemoService memoService = new MemoService(jdbcTemplate);
        //Controller 메서드 이름과 Service 메서드 이름을 일치하여 코드 통일성을 주면 좋음
        return memoService.createMemo(requestDto);

    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // 객체간 이동을 위해 MemoService 객체 생성
        MemoService memoService = new MemoService(jdbcTemplate);

        return memoService.getMemos();

    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 객체간 이동을 위해 MemoService 객체 생성
        MemoService memoService = new MemoService(jdbcTemplate);
        
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 객체간 이동을 위해 MemoService 객체 생성
        MemoService memoService = new MemoService(jdbcTemplate);

        return memoService.deleteMemo(id);
    }

}