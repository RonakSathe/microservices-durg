package com.ronak.hotel.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException resourceNotFoundException){
        Map map = new HashMap();
        map.put("message",resourceNotFoundException.getMessage());
        map.put("success", HttpStatus.NOT_FOUND);
        map.put("status",false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
