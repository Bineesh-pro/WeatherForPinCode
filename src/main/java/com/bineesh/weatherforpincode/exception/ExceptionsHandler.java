package com.bineesh.weatherforpincode.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(InvalidOrErrorException.class)
    public ResponseEntity<ErrorReponse> handleException(InvalidOrErrorException exception){
        return ResponseEntity.badRequest()
                .body(new ErrorReponse(exception.getMessage(),"invalid pincode..no details for this pincode found"));
    }

}
