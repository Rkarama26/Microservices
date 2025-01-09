package com.example.UserService.exception;

import com.example.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> hanldeResourceNotFoundException(ResourceNotFoundException ex)
    {
     String message = ex.getMessage();
     ApiResponse response = new ApiResponse(message, true, HttpStatus.NOT_FOUND);
      return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
