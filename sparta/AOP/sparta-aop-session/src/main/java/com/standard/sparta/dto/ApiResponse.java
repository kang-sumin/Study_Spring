package com.standard.sparta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final String message;
    private final Integer statusCode;
    private final T data;

    private ApiResponse(String message, Integer statusCode, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    /**
     * 성공 응답 생성
     */
    public static <T> ApiResponse<T> createSuccess(String message, Integer statusCode, T data) {
        return new ApiResponse<>(message, statusCode, data);
    }

    /**
     * 에러 응답 생성
     */
    public static <T> ApiResponse<T> createError(String message, Integer statusCode) {
        return new ApiResponse<>(message, statusCode, null);
    }
}
