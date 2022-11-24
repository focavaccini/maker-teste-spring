package com.maker.exercicioquatro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maker.exercicioquatro.entities.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long>{

	Sku findByCodigoBarra(String barCode);
}
