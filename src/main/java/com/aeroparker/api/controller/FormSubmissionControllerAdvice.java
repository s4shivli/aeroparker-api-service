package com.aeroparker.api.controller;

import com.aeroparker.api.exception.AeroParkerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class FormSubmissionControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public void HandleWhenInternalServerError() {
        log.info("Internal server error");
    }

    @ExceptionHandler({AeroParkerException.class})
    public ResponseEntity<String> handleAeroParkerException(AeroParkerException aeroParkerException) {
        log.info("Bad request");
        return new ResponseEntity<>(aeroParkerException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

