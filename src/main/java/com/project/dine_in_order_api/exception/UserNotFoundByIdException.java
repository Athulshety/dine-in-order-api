package com.project.dine_in_order_api.exception;

public class UserNotFoundByIdException extends RuntimeException {
    private final String message;

    public UserNotFoundByIdException(String message){
        this.message=message;
    }
    @Override
    public String getMessage(){
        return message;
    }

}
