package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.Monitoreo;
import com.bike.dto.usuario.Usuario;

public interface MonitoreoRepo extends JpaRepository<Monitoreo, Usuario> {
	
	Monitoreo findByUsuario(Usuario usuario);
	
	List<Monitoreo> findAll();
	
	}