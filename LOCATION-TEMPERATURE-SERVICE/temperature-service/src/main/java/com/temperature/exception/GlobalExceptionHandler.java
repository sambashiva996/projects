package com.temperature.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TemperatureException.class)
    public ResponseEntity<Map<String, Object>> handleTemperatureException(TemperatureException ex) {
        Map<String, Object> response = Map.of("message", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

}
