package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 0;

    @GetMapping("/static-hello")
    public String hello(){
        return "hello.html";
    }

    //thymeleaf 엔진 사용했을때 정적 페이지 반환 방법
    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }

    //thymeleaf 엔진을 이용한 정적 페이지 반환
    @GetMapping("/html/templates")
    public String htmlTemplates(){
        return "hello";
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model){
        visitCount++;
        model.addAttribute("visits",visitCount);
        return "hello-visit";
    }
}
