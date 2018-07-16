package com.briansjavablog.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.briansjavablog.microservices.currencyconversionservice.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, 
											  @PathVariable String to, 
											  @PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
																"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
																CurrencyConversion.class, 
																uriVariables);
		
		CurrencyConversion response = responseEntity.getBody();
		
		return new CurrencyConversion(response.getId(), response.getFromCurrency(), response.getToCurrency(), response.getConversionRate(), 
									   quantity, quantity.multiply(response.getConversionRate()), response.getPort());
	}
	
}
