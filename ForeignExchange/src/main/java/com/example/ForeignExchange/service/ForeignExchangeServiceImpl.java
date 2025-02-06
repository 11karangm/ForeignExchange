/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ForeignExchange.service;

import com.example.ForeignExchange.DTO.ExchangeRateResponseDTO;
import com.example.ForeignExchange.DTO.RequestDTO;
import com.example.ForeignExchange.DTO.ResponseDTO;
import com.example.ForeignExchange.exception.ExternalException;
import com.example.ForeignExchange.exception.InvalidCurrencyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 9685
 */
@Service
@Transactional
public class ForeignExchangeServiceImpl implements ForeignExchangeService{
    
    @Value("${api.url}")
    public String apiUrlExternal;

    @Override
    public ExchangeRateResponseDTO getRates(String base) {
        try{
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = apiUrlExternal + base;
        // Call the external API
        // Fetch the API response and map it to DTO
        ResponseEntity<ExchangeRateResponseDTO> responseEntity =
        restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ExchangeRateResponseDTO>() {});
        ExchangeRateResponseDTO responseBody = responseEntity.getBody();

        return responseBody;
        
        } catch (HttpStatusCodeException e) { // Handle HTTP errors (4xx, 5xx)
            throw new ExternalException(
                    e.getStatusCode(),
                    "External API Failure - " + e.getResponseBodyAsString()
            );
        } catch (Exception e) { // Handle timeout, network failures
            throw new ExternalException(HttpStatus.SERVICE_UNAVAILABLE,"Failed to fetch exchange rates. API might be down.");
        }
    }
    
    public ResponseDTO convertCurrency(RequestDTO dto){
        try{
        ResponseDTO dtoResponse = new ResponseDTO();
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = apiUrlExternal + dto.getFrom();
        ResponseEntity<ExchangeRateResponseDTO> responseEntityCheck =
        restTemplate.exchange(apiUrlExternal+"usd", HttpMethod.GET, null, new ParameterizedTypeReference<ExchangeRateResponseDTO>() {});
        ExchangeRateResponseDTO ratesCheck = responseEntityCheck.getBody();
        if (!ratesCheck.getRates().containsKey(dto.getFrom()) || !ratesCheck.getRates().containsKey(dto.getTo())) {
                throw new InvalidCurrencyException("Invalid currency code provided: " + dto.getFrom() + " or " + dto.getTo());
            }
        // Call the external API
        // Fetch the API response and map it to DTO
//        ResponseEntity responseCheck = restTemplate.getForObject(apiUrl, ResponseEntity.class);
        
        ResponseEntity<ExchangeRateResponseDTO> responseEntity =
        restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ExchangeRateResponseDTO>() {});
        ExchangeRateResponseDTO rates = responseEntity.getBody();
        
//        if(responseCheck.getStatusCodeValue()==200){
//            ExchangeRateResponseDTO response = restTemplate.getForObject(apiUrl, ExchangeRateResponseDTO.class);
//            // Return only the "rates" map
//            ExchangeRateResponseDTO rates = restTemplate.getForObject(apiUrl, ExchangeRateResponseDTO.class);
//        
//            if (rates== null) {
//                throw new ExternalException("Exchange rate API returned an invalid response.");
//            }
//            
//            //  Validate if the currency codes exist in the API response
            

        double convertedAmount = dto.getAmount() * rates.getRates().get(dto.getTo()); 
        dtoResponse.setConvertedAmount(convertedAmount);
        dtoResponse.setFrom(dto.getFrom());
        dtoResponse.setAmount(dto.getAmount());
        dtoResponse.setTo(dto.getTo());
        return dtoResponse;
        
        
        }catch (InvalidCurrencyException e) { // Handle InvalidCurrency errors (4xx, 5xx)
            
            throw new InvalidCurrencyException("Invalid currency code provided: " + dto.getFrom() + " or " + dto.getTo());
           
        } catch (HttpStatusCodeException e) { // Handle HTTP errors (4xx, 5xx)
            throw new ExternalException(
                    e.getStatusCode(),
                    "External API Failure - " + e.getResponseBodyAsString()
            );
        } catch (Exception e) { // Handle timeout, network failures
            throw new ExternalException(HttpStatus.SERVICE_UNAVAILABLE,"Failed to fetch exchange rates. API might be down.");
        }
    }

    
}
