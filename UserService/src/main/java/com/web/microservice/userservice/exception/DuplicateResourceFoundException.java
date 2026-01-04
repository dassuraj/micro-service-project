package com.web.microservice.userservice.exception;

public class DuplicateResourceFoundException extends RuntimeException{

    public DuplicateResourceFoundException(String resourceName, String field , Object value){

        super(resourceName + " with " + field + " = " + value + "already exists");
    }


    public DuplicateResourceFoundException(String message){
        super(message);
    }

}
