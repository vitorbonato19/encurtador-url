package dev.vitor.url.exceptions;

import org.springframework.http.HttpStatus;

public class UrlExpiredException extends RuntimeException {

    private final HttpStatus status;

    public UrlExpiredException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
