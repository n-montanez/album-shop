package com.example.simple_api.errors;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.simple_api.model.error.ErrorResponse;

@RestControllerAdvice
public class ResourceNotFoundAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse albumNotFound(ResourceNotFoundException ex) {
        return new ErrorResponse(404, ex.getMessage());
    }
}
