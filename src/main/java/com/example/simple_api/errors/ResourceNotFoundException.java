package com.example.simple_api.errors;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(UUID id) {
        super("Album not found: " + id);
    }
}
