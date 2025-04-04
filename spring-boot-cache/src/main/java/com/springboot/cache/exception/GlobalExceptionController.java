package com.springboot.cache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Map<String, Object>> productException(ProductException productException){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("errorMessage", productException.getMessage());
        errorMap.put("errorCode", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

}
