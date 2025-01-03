package dev.vitor.url.handler;

import dev.vitor.url.exceptions.UrlNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UrlNotFoundExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<Map<String, Object>> urlNotFoundException(UrlNotFoundException ex, HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", ex.getStatus());
        response.put("statusCode", ex.getStatus().value());
        response.put("error", ex.getMessage());
        response.put("path", request.getRequestURI());

        return new ResponseEntity<>(response, ex.getStatus());
    }

}
