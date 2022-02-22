package com.cap.order.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@CreatedDate
	LocalDate date=LocalDate.now();
	@OneToMany(mappedBy = "commande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Composant> composants=new ArrayList<>();
	
	@Transient
	Client client;
	
	long idclient;
}
