package com.web.microservice.ratingservice.exceptions;


public class InvalidDataException extends RuntimeException{

    public InvalidDataException(String message){
        super(message);
    }

}
