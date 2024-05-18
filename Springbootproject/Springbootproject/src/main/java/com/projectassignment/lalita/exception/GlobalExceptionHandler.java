package com.projectassignment.lalita.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<MyErrorDetails> projectExceptionHandler(ProjectException pe, WebRequest wr) {
        MyErrorDetails md = new MyErrorDetails();
        md.setMessage(pe.getMessage());
        md.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(md, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> anyExceptionHandler(Exception ex, WebRequest wr) {

        MyErrorDetails md = new MyErrorDetails();
        md.setMessage(ex.getMessage());
        md.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(md, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noHandlerFound(NoHandlerFoundException ex, WebRequest wr) {

        MyErrorDetails md = new MyErrorDetails();
        md.setMessage(ex.getMessage());
        md.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(md, HttpStatus.BAD_REQUEST);
    }



}
