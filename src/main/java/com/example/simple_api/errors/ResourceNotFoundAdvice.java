package com.example.simple_api.errors;

import java.util.HashMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceNotFoundAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public HashMap<String, String> albumNotFound(ResourceNotFoundException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
}
