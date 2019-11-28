package com.bike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.Bicicleta;
import com.bike.dto.usuario.Usuario;


public interface BicicletaRepo extends JpaRepository<Bicicleta, Long> {
	
	List<Bicicleta> findByUsuario(Usuario usuario);
	Bicicleta findByBiciId(long biciId);


}
