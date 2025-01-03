package dev.vitor.url.exceptions;

import dev.vitor.url.entities.Url;
import org.springframework.http.HttpStatus;

public class UrlNotFoundException extends RuntimeException {

    private HttpStatus status;

    public UrlNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
    
}
