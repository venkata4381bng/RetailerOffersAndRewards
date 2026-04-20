package com.retailerOffers.demo.exception;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Error Message Alert -->: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}