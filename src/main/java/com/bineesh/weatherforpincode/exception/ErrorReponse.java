package com.bineesh.weatherforpincode.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorReponse {
    String error;
    String message;
}
