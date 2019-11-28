package com.bike.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.PrestamoRepo;
import com.bike.dto.Prestamo;

@Service
public class PrestamoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PrestamoRepo dao;

    public Prestamo save(Prestamo prestamo){
    	logger.info("Registrando prestamo - {}", prestamo.getPrestFechaInicio());
        return dao.saveAndFlush(prestamo);
    }
}