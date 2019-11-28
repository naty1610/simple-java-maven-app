package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.Prestamo;


public interface PrestamoRepo extends JpaRepository<Prestamo, Long> {
	
	List<Prestamo> findByBicicleta(long bicicletaId);

}
