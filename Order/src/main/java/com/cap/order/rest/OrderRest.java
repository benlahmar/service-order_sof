package com.cap.order.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.order.entities.Client;
import com.cap.order.entities.Commande;
import com.cap.order.entities.Composant;
import com.cap.order.entities.Produit;
import com.cap.order.remote.IRCatalogue;
import com.cap.order.remote.IRClient;
import com.cap.order.repo.ICommande;
import com.cap.order.repo.IComposant;

@RestController
public class OrderRest {

	@Autowired
	ICommande crepo;
	@Autowired
	IComposant coprepo;
	@Autowired
	IRClient remoteclient;
	@Autowired
	IRCatalogue remotecatalogue;
	
	@PostMapping("/orders")
	public ResponseEntity<Commande> save(@RequestBody Commande c)
	{
		//verifier la presence du client
		//=> contacter le microservice customer-service
		Client cl=remoteclient.getClient(c.getIdclient());
		
		if(cl!=null) 
		{
			c=crepo.save(c);
			c.setClient(cl);
		return new ResponseEntity<Commande>(c, HttpStatus.OK);}
		else
			return new ResponseEntity<Commande>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("orders/{idcmd}/composants")
	public ResponseEntity<Composant> savecomp(@RequestBody Composant cp,@PathVariable long idcmd)
	{
		Produit p = remotecatalogue.getproduit(cp.getIdproduit());
		if(p!=null)
		{
			
			cp=coprepo.save(cp);
			cp.setProduit(p);
			return new ResponseEntity<Composant>(cp,HttpStatus.OK);
		}
		else
				return new ResponseEntity<Composant>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/orders/{id}")
	public Commande getcmd(@PathVariable long id) throws Exception
	{
		Optional<Commande> co = crepo.findById(id);
		if(co.isPresent())
			return co.get();
		else
			 throw new Exception();
	}
}
