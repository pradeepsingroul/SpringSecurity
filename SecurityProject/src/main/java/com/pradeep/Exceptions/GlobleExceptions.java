package com.pradeep.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobleExceptions {


    @ExceptionHandler(SttudentExceptions.class)
    public ResponseEntity<MyErrorDetails> studentExceptionHandler(SttudentExceptions st, WebRequest webRequest) {
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setLcdt(LocalDateTime.now());
        errorDetails.setMessage(st.getMessage());
        errorDetails.setDescroption(webRequest.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> methodArgument(MethodArgumentNotValidException st, WebRequest webRequest) {
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setLcdt(LocalDateTime.now());
        errorDetails.setMessage(st.getMessage());
        errorDetails.setDescroption(webRequest.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noArgument(NoHandlerFoundException st, WebRequest webRequest) {
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setLcdt(LocalDateTime.now());
        errorDetails.setMessage(st.getMessage());
        errorDetails.setDescroption(webRequest.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exception(Exception st, WebRequest webRequest) {
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setLcdt(LocalDateTime.now());
        errorDetails.setMessage(st.getMessage());
        errorDetails.setDescroption(webRequest.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
    }


}
