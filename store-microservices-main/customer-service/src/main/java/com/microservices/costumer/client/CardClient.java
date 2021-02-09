package com.microservices.costumer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.customer.model.Card;

@FeignClient(name = "payment-service")
@RequestMapping("/cards")
public interface CardClient {
	
	public List<Card> findCardsByCustomerId(Long customerId);
	
}
