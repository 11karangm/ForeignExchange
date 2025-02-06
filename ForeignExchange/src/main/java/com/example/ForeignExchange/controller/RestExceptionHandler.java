/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.controller;

import com.example.ForeignExchange.controller.*;
import com.example.ForeignExchange.exception.ApiException;
import com.example.ForeignExchange.exception.ApiException;
import com.example.ForeignExchange.exception.ExternalException;
import com.example.ForeignExchange.exception.ExternalException;
import com.example.ForeignExchange.exception.InvalidCurrencyException;
import com.example.ForeignExchange.exception.InvalidCurrencyException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 9685
 */
@RestController
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value=ExternalException.class)
    public ResponseEntity<Object> HandleExternalException(ExternalException e){
        //1.create json structure
        ApiException apiException = new ApiException(
        e.getMessage(),
        e.getStatus(),
        ZonedDateTime.now(ZoneId.of("Z"))
        );
        //2.return response
        return new ResponseEntity<> (apiException,HttpStatus.SERVICE_UNAVAILABLE);
    }
    
    @ExceptionHandler(value=InvalidCurrencyException.class)
    public ResponseEntity<Object> HandlInvalidCurrencyException(InvalidCurrencyException e){
        //1.create json structure
        ApiException apiException = new ApiException(
        e.getMessage(),
        HttpStatus.BAD_REQUEST,
        ZonedDateTime.now(ZoneId.of("Z"))
        );
        //2.return response
        return new ResponseEntity<> (apiException,HttpStatus.BAD_REQUEST);
    }
}
