package com.project.dine_in_order_api.exception.handler;

import com.project.dine_in_order_api.exception.UserNotFoundByIdException;
import com.project.dine_in_order_api.util.ResponseBuilder;
import com.project.dine_in_order_api.util.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> getMessage(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
