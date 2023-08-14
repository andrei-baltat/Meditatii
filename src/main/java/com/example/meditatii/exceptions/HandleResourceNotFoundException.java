package com.example.meditatii.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class HandleResourceNotFoundException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleStudentNotFoundException
            (ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        ErrorDetails errorDetails =
                new ErrorDetails(LocalDateTime.now(),
                        resourceNotFoundException.getMessage(),
                        webRequest.getDescription(false),
                        "Entity not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
