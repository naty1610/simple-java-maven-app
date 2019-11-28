package com.bike.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.dto.usuario.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsuId(long usuId);
	Usuario findByUsuCorreoAndUsuPassword(String correo, String password);
	Usuario findByUsuCorreo(String correo);

	

}
