package com.bineesh.weatherforpincode.exception;

import org.springframework.http.HttpStatusCode;

public class InvalidOrErrorException extends RuntimeException {
    public InvalidOrErrorException(String msg) {
        super(msg);
    }
}
