package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.Beneficio;

public interface BeneficioRepo extends JpaRepository<Beneficio, Long> {
	
	Beneficio findByBeneId(Long beneId);
	
	List<Beneficio> findAll();
	
	}