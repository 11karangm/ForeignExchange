/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.DTO;

/**
 *
 * @author 9685
 */
public class RequestDTO {
     private String from;
    private String to;
    private double amount;

    // Constructors
    public RequestDTO() {}

    public RequestDTO(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    // Getters and Setters
    public String getFrom() { 
        return from; 
    }
    public void setFrom(String from) {
        this.from = from; 
    }

    public String getTo() { 
        return to; 
    }
    public void setTo(String to) { 
        this.to = to; 
    }

    public double getAmount() { 
        return amount; 
    }
    public void setAmount(double amount) { 
        this.amount = amount; 
    }
    
}
