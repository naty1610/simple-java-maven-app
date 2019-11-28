package com.bike.dto.usuario;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class UsuarioSocial extends Usuario{
	
	public UsuarioSocial() {
		super();
	}
	
	public UsuarioSocial(String usuUsuario, String usuNombre, String usuCorreo, String usuPassword) {
		super(usuUsuario, usuNombre, usuCorreo, usuPassword);
		
	}

}
