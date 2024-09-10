package com.standard.sparta.exception;

public class DuplicateCourseNameException extends RuntimeException {
    public DuplicateCourseNameException() {
        super("수업 이름 중복");
    }
}
