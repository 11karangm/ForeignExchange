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
public class ResponseDTO {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;

    // Constructor
    public ResponseDTO(String from, String to, double amount, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public ResponseDTO() {
    }

    // Getters
    public String getFrom() { 
        return from; 
    }
    
    public String getTo() { 
        return to; 
    }
    
    public double getAmount() { 
        return amount; 
    }
    
    public double getConvertedAmount() { 
        return convertedAmount; 
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
