package com.standard.sparta.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExceptionService {
    public void callCheckedException() throws Exception {
        // 체크예외
        throw new Exception();
//        try {
//            throw new Exception();
//        } catch (Exception e) {
//            log.info("예외 처리");
//        }
    }

    public void callUncheckedException() {
        // 언체크 예외
        throw new RuntimeException();
    }
}
