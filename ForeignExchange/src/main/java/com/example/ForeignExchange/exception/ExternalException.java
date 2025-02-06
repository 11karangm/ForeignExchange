/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.exception;

import com.example.ForeignExchange.service.*;
import org.springframework.http.HttpStatus;

/**
 *
 * @author 9685
 */
public class ExternalException extends RuntimeException {
    private final HttpStatus status;

    public ExternalException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
