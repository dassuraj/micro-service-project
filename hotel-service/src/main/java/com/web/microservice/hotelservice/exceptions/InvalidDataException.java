package com.web.microservice.hotelservice.exceptions;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(String message){

        super(message);

    }
}
