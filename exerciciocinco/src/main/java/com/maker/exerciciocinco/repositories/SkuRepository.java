package com.maker.exerciciocinco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maker.exerciciocinco.entities.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long>{

	Sku findByCodigoBarra(String barCode);
}
