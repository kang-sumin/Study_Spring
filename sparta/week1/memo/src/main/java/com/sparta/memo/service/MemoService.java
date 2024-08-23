package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

// Bean으로 등록
// @Component
@Service
public class MemoService {
    // Bean으로는 memoService로 등록됨

    private final MemoRepository memoRepository;

    // 생성자가 1개여서 @Autowired 생략 가능
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }


    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // DB 저장
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(saveMemo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회

        return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();

    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {

        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);

        // memo 내용 수정
        memo.update(requestDto);

        return id;
    }

    public Long deleteMemo(Long id) {

        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);

        // memo 삭제
        memoRepository.delete(memo);

        return id;
    }

    private Memo findMemo(Long id){
        return memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }

}
