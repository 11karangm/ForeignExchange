/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.controller;

import com.example.ForeignExchange.DTO.ExchangeRateResponseDTO;
import com.example.ForeignExchange.DTO.RequestDTO;
import com.example.ForeignExchange.DTO.ResponseDTO;
import com.example.ForeignExchange.exception.ExternalException;
import com.example.ForeignExchange.service.ForeignExchangeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Vishnupriya <vishnupriya@sblsoftware.com>
 */
@RestController
@RequestMapping("/api")
//@CrossOrigin
public class ForeignExchangeController {
    @Autowired
    ForeignExchangeService foreignExchangeService;
 
    @GetMapping("rates")
    public ResponseEntity getRates(@RequestParam(defaultValue = "USD") String base){
            ExchangeRateResponseDTO response = foreignExchangeService.getRates(base);
            return ResponseEntity.ok(response.getRates());       
    }
    
    @PostMapping("convert")
    public ResponseDTO ConvertCurrency(@RequestBody RequestDTO dto) throws Exception{
        ResponseDTO response = foreignExchangeService.convertCurrency(dto);
        return response;
    }


}
