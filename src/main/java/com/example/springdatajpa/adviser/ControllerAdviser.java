package com.example.springdatajpa.adviser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class ControllerAdviser {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HashMap<String, Object> handleMethodArgumentNotValid( MethodArgumentNotValidException exception) {
        List<HashMap<String,Object>> errors =
        exception.getBindingResult().getFieldErrors().stream().map(error -> {
            HashMap<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("field",error.getField());
            errorResponse.put("message",error.getDefaultMessage());
            return errorResponse;
        }).toList();
        HashMap<String,Object> response = new HashMap<>();
        response.put("errors",errors);

        return  response;
    }
}
