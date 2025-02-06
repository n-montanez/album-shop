package com.example.simple_api.model.error;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status, String message) {
        this.timestamp = Instant.now().toString();
        this.status = status;
        this.error = HttpStatus.valueOf(status).toString();
        this.message = message;
    }

}
