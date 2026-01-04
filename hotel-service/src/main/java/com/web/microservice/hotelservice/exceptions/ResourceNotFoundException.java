package com.web.microservice.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String resourceName , String field , Object value){

        super(resourceName + "not found with " + field + " = " + value);

    }

    public ResourceNotFoundException(String message){

        super(message);

    }
}
