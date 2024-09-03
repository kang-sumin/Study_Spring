package com.sparta.springauth.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Spring Security 지원을 가능하게 함
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 설정 : csrf 사용하지 않도록 설정함
        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()// resources 접근 허용 설정
                        .anyRequest().authenticated() // 그 외 모든 요청 인증처리
//                        .requestMatchers("/api/user/**").permitAll() -> /api/user/로 시작되는 모든 페이지 접근 허용 설정
        );

        // 로그인 사용
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }
}