package com.cap.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.order.entities.Commande;

public interface ICommande extends JpaRepository<Commande, Long>{

}
