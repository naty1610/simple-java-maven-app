package com.bike.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.RutaRepo;
import com.bike.dto.ruta.Ruta;

@Service
public class RutaService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RutaRepo dao;

    public Ruta save(Ruta ruta){
    	logger.info("Se agrega ruta - {}", ruta.getRutaId());
        return dao.saveAndFlush(ruta);
    }
}