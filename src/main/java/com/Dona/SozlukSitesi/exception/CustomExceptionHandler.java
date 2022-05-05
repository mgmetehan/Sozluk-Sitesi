package com.Dona.SozlukSitesi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException notFoundException) {
        List<String> details = new ArrayList<String>();
        details.add(notFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Not Found Exception", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
