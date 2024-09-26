package com.sparta.redistest.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping
    public String temp(){
        return "이게 되네";
    }

    @GetMapping("/test")
    public String temp1(){
        String title = "이론수업 개꿀";

        redisTemplate.opsForValue().set("title", title);
        return title;
    }

    @GetMapping("/test/get")
    public String temp2(){
        String result =(String) redisTemplate.opsForValue().get("title");
        return result;
    }
}
