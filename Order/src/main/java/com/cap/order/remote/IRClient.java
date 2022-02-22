package com.cap.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cap.order.entities.Client;

@FeignClient(name = "customer-service", url = "localhost:8010")
public interface IRClient {
	
	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable long id);
	
	
}
