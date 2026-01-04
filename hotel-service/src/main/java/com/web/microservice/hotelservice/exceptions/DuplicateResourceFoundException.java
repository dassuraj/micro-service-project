package com.web.microservice.hotelservice.exceptions;

public class DuplicateResourceFoundException extends RuntimeException{


    public DuplicateResourceFoundException(String message){
        super(message);
    }

    public DuplicateResourceFoundException(String resourceName, String field , Object value){

        super(resourceName + " with " + field + " = " + value + "already exists");
    }
}
