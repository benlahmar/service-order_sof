package com.cap.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cap.order.entities.Produit;

@FeignClient(name = "catalogue-service", url = "localhost:8004")
public interface IRCatalogue {

	@GetMapping("/produits/{id}")
	public Produit getproduit(@PathVariable long id);
}
