package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/static-hello")
    public String hello(){
        return "hello.html";
    }

    //thymeleaf 엔진 사용했을때 정적 페이지 반환 방법
    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }
}
