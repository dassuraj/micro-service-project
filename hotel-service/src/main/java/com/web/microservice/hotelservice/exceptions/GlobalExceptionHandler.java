package com.web.microservice.hotelservice.exceptions;

import com.web.microservice.hotelservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(DuplicateResourceFoundException.class)
    public ResponseEntity<ApiResponse> handleDuplicateResourceFoundException(DuplicateResourceFoundException ex){

        String message = ex.getMessage();

        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.CONFLICT)
                .build();

        return new ResponseEntity<ApiResponse>(response,HttpStatus.CONFLICT);
    }


    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ApiResponse> handleInvalidDataException(InvalidDataException ex){
        String message = ex.getMessage();

        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return  new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){

        String message = ex.getMessage();

        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }

}
