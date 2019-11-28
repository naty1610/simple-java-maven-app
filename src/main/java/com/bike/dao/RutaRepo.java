package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.ruta.Ruta;
import com.bike.dto.usuario.Usuario;

public interface RutaRepo extends JpaRepository<Ruta, Usuario> {
	
	List<Ruta> findByUsuario(Usuario usuario);
	
	Ruta findByRutaId(Long rutaId);
	
	List<Ruta> findAll();
	
	}