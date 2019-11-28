package com.bike.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.BeneficioRepo;
import com.bike.dto.Beneficio;

@Service
public class BeneficioService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BeneficioRepo dao;

    public Beneficio save(Beneficio beneficio){
    	logger.info("Se agrega beneficio - {}", beneficio.getBeneDescripcion());
        return dao.saveAndFlush(beneficio);
    }
}