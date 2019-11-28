package com.bike.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.MonitoreoRepo;
import com.bike.dto.Monitoreo;

@Service
public class MonitoreoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MonitoreoRepo dao;

    public Monitoreo save(Monitoreo monitoreo){
    	logger.info("Sincronizando monitoreo para usuario: {}", monitoreo.getUsuario().getUsuUsuario());
        return dao.saveAndFlush(monitoreo);
    }
}