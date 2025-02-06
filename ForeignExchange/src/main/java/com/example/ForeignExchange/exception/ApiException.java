/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.exception;

import com.example.ForeignExchange.service.*;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author 9685
 */
public class ApiException {
    
    private final String message;
    private final HttpStatus httpstat;
    private final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus httpstat, ZonedDateTime timestamp) {
        this.message = message;
        this.httpstat = httpstat;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpstat() {
        return httpstat;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
    
}
