package com.location.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LocationServiceException.class)
    public ResponseEntity<Map<String, Object>> handleException(LocationServiceException e) {

        Map<String, Object> errorMap = Map.of("message", e.getMessage());

        return ResponseEntity.badRequest().body(errorMap);
    }
}
