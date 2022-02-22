package com.cap.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.order.entities.Composant;

public interface IComposant extends JpaRepository<Composant, Long>{

}
