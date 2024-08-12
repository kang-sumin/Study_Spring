package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/api/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!!";
    }

    @GetMapping("/api/get")
    @ResponseBody
    public String get(){
        return "Get Method 요청";
    }

    @PostMapping("/api/post")
    @ResponseBody
    public String post(){
        return "Post Method 요청";
    }

    @PutMapping("/api/put")
    @ResponseBody
    public String put(){
        return "Put Method 요청";
    }

    @DeleteMapping("/api/delete")
    @ResponseBody
    public String delete(){
        return "Delete Method 요청";
    }

}
