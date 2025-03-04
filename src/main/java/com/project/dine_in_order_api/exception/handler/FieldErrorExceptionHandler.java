package com.project.dine_in_order_api.exception.handler;

import com.project.dine_in_order_api.util.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<FieldErrorResponse.FieldError> errors = new ArrayList<>();
        List<ObjectError> objectErrors=ex.getAllErrors();


        for (ObjectError objectError :objectErrors ) {
                FieldError fieldError=(FieldError) objectError;
                FieldErrorResponse.FieldError error =  FieldErrorResponse.fieldError(
                        objectError.getDefaultMessage(),
                        fieldError.getRejectedValue(),
                        fieldError.getField());

                errors.add(error);
            }


        FieldErrorResponse errorResponse =  FieldErrorResponse.builder()
                .type(status.toString())
                .message("Invalid request parameters")
                .errors(errors)
                .build();
        return ResponseEntity.status(status).body(errorResponse);



    }

}