package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.Robo;

public interface RoboRepo extends JpaRepository<Robo, Long> {
	
	List<Robo> findByBicicleta(long bicicletaId);

}
