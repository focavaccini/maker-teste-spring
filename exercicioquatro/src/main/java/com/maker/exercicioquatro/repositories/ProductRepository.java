package com.maker.exercicioquatro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maker.exercicioquatro.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
