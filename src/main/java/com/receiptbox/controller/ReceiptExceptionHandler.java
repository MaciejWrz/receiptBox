package com.receiptbox.controller;

import com.receiptbox.exception.ReceiptValidationException;
import com.receiptbox.exception.ReceiptNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReceiptExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ReceiptValidationException.class, ReceiptNotFoundException.class})
    public ResponseEntity<Object> handleBadRequestException(Exception e, WebRequest webRequest) {
        return new ResponseEntity<Object>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
