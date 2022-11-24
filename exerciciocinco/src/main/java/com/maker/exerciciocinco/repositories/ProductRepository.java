package com.maker.exerciciocinco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maker.exerciciocinco.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
