package com.cap.order.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Composant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int quantity;
	double prix;
	
	@ManyToOne
	Commande commande;
	
	@Transient
	Produit produit;
	long idproduit;
}
