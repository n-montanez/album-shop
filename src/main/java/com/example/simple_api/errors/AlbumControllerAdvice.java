package com.example.simple_api.errors;

import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import io.micrometer.common.util.StringUtils;

import com.example.simple_api.model.error.ApiErrorResponse;

@ControllerAdvice
public class AlbumControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        String ERROR_MESSAGE = ex.getMessage();
        try {
            ERROR_MESSAGE = ex.getBindingResult().getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        } catch (Exception e) {
            logger.error("Error constructing error message", e);
        }

        ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.BAD_REQUEST, ERROR_MESSAGE);
        return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception,
            WebRequest webRequest) {
        final String ERROR_MESSAGE = exception.getMessage();
        ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.BAD_REQUEST, ERROR_MESSAGE);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest webRequest) {
        final String ERROR_MESSAGE = "An unexpected error occurred";
        ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MESSAGE);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                webRequest);
    }

    private ApiErrorResponse getErrorResponse(HttpStatus status, String errorMessage) {
        if (StringUtils.isEmpty(errorMessage)) {
            errorMessage = "An unexpected error occurred";
        }
        return new ApiErrorResponse(status.value(), errorMessage);
    }

}
