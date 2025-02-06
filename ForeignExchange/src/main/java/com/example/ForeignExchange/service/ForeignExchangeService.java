/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.service;

import com.example.ForeignExchange.DTO.ExchangeRateResponseDTO;
import com.example.ForeignExchange.DTO.RequestDTO;
import com.example.ForeignExchange.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 9685
 */
@Service
@Transactional
public interface ForeignExchangeService{

    public ExchangeRateResponseDTO getRates(String base);

    public ResponseDTO convertCurrency(RequestDTO dto);
    
}
