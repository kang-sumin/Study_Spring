package com.standard.sparta.controller;

import com.standard.sparta.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/exception")
@RestController
@RequiredArgsConstructor
public class ExceptionController {

    private final ExceptionService exceptionService;

    /**
     * 체크 예외 사용 방법
     */
    @GetMapping("/checked")
    public String checkedExceptionAPI() throws Exception {
            exceptionService.callCheckedException();
//        try {
//            exceptionService.callCheckedException();
//        } catch (Exception e) {
//            log.info("예외 처리");
//        }
        return "checked";
    }

    /**
     * 언체크 예외 사용 방법
     */
    @GetMapping("/unchecked")
    public String uncheckedExceptionAPI() throws Exception {
        exceptionService.callUncheckedException();
        return "unchecked";
    }
}
