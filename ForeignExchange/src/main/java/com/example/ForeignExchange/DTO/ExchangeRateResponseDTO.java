/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.DTO;

import java.util.Map;

/**
 *
 * @author 9685
 */
public class ExchangeRateResponseDTO {
    
     private Map<String, Double> rates;

    // Getter and Setter
    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
    
}
