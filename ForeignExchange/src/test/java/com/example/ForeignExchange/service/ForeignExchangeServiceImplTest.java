package com.example.ForeignExchange.service;

import com.example.ForeignExchange.DTO.ExchangeRateResponseDTO;
import com.example.ForeignExchange.DTO.RequestDTO;
import com.example.ForeignExchange.DTO.ResponseDTO;
import com.example.ForeignExchange.exception.ExternalException;
import com.example.ForeignExchange.exception.InvalidCurrencyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ForeignExchangeServiceImplTest {

//    @InjectMocks
//    private ForeignExchangeServiceImpl foreignExchangeService;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    private ExchangeRateResponseDTO mockRates;
//
//    @BeforeEach
//    void setUp() {
//        // Mock exchange rates
//        mockRates = new ExchangeRateResponseDTO();
//        Map<String, Double> rates = new HashMap<>();
//        rates.put("EUR", 0.92);
//        rates.put("INR", 82.50);
//        mockRates.setRates(rates);
//    }

    /**
     *  Test: Fetch exchange rates successfully
     */
//    @Test
//    void testGetRates_Success() {
//        String baseCurrency = "USD";
//        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
//
//    //  Mock RestTemplate exchange call
//    when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), eq(null),
//            any(ParameterizedTypeReference.class)))
//            .thenReturn(new ResponseEntity<>(mockRates, HttpStatus.OK));
//
//        ExchangeRateResponseDTO response = foreignExchangeService.getRates(baseCurrency);

//        assertNotNull(response);
//        assertNotNull(response.getRates());
//        assertEquals(0.92, response.getRates().get("EUR"));
//    }

//    /**
//     *  Test: API Failure should throw ExternalException
//     */
//    @Test
//    void testGetRates_ApiFailure() {
//        String baseCurrency = "USD";
//        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
//
//        lenient().when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), eq(null),
//                any(ParameterizedTypeReference.class)))
//                .thenThrow(new ExternalException(HttpStatus.SERVICE_UNAVAILABLE, "API down"));
//
//        ExternalException exception = assertThrows(ExternalException.class,
//                () -> foreignExchangeService.getRates(baseCurrency));
//
//        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, exception.getStatus());
//        assertTrue(exception.getMessage().contains("API might be down"));
//    }
//
//    /**
//     *  Test: Successful currency conversion
//     */
//    @Test
//    void testConvertCurrency_Success() {
//        RequestDTO requestDTO = new RequestDTO("USD", "EUR", 100);
//
//        String apiUrl = "https://api.exchangerate-api.com/v4/latest/USD";
//
//        lenient().when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), eq(null),
//                any(ParameterizedTypeReference.class)))
//                .thenReturn(new ResponseEntity<>(mockRates, HttpStatus.OK));
//
//        ResponseDTO response = foreignExchangeService.convertCurrency(requestDTO);
//
//        assertNotNull(response);
//        assertEquals("USD", response.getFrom());
//        assertEquals("EUR", response.getTo());
//        assertEquals(100 * 0.92, response.getConvertedAmount());
//    }
//
//    /**
//     *  Test: Invalid currency throws InvalidCurrencyException
//     */
//    @Test
//    void testConvertCurrency_InvalidCurrency() {
//        RequestDTO requestDTO = new RequestDTO("XYZ", "EUR", 100);
//
//        String apiUrl = "https://api.exchangerate-api.com/v4/latest/XYZ";
//
//        lenient().when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), eq(null),
//                any(ParameterizedTypeReference.class)))
//                .thenReturn(new ResponseEntity<>(mockRates, HttpStatus.OK));
//
//        InvalidCurrencyException exception = assertThrows(InvalidCurrencyException.class,
//                () -> foreignExchangeService.convertCurrency(requestDTO));
//
//        assertTrue(exception.getMessage().contains("Invalid currency code provided"));
//    }
//
//    /**
//     *  Test: API Failure during currency conversion
//     */
//    @Test
//    void testConvertCurrency_ApiFailure() {
//        RequestDTO requestDTO = new RequestDTO("USD", "EUR", 100);
//
//        String apiUrl = "https://api.exchangerate-api.com/v4/latest/USD";
//
//        lenient().when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), eq(null),
//                any(ParameterizedTypeReference.class)))
//                .thenThrow(new ExternalException(HttpStatus.SERVICE_UNAVAILABLE, "API down"));
//
//        ExternalException exception = assertThrows(ExternalException.class,
//                () -> foreignExchangeService.convertCurrency(requestDTO));
//
//        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, exception.getStatus());
//        assertTrue(exception.getMessage().contains("API down"));
//    }
}
