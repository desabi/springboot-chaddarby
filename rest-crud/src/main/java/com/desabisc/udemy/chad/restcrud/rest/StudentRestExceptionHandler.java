package com.desabisc.udemy.chad.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

  // add exception handling code here

  // Add an exception handles using @ExceptionHandler
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
    // create a StudentErrorResponse
    StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
    studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    studentErrorResponse.setMessage(ex.getMessage());
    studentErrorResponse.setTimeStamp(System.currentTimeMillis());

    // return ResponseEntity
    return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
  }

  // add another exception handler ... to catch any exception (catch all)
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {

    // create a StudentErrorResponse
    StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
    studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    studentErrorResponse.setMessage(ex.getMessage());
    studentErrorResponse.setTimeStamp(System.currentTimeMillis());

    // return ResponseEntity
    return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
  }

}
