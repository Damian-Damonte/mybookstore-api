package com.silvercsoft.test.mybookstoreapi.exception;

import com.silvercsoft.test.mybookstoreapi.dto.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> badRequestExceptionHandler(BadRequestException e) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(HttpStatus.BAD_REQUEST.value()).addError(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(HttpStatus.NOT_FOUND.value()).addError(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value());
        e.getBindingResult().getFieldErrors().forEach(error -> response.addError(error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value()).addError("internal server error"));
    }
}
