package com.bike.dto.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long usuId;
	
	@Column(columnDefinition = "text")
	private String usuUsuario;
	
	@Column(columnDefinition = "text")
	private String usuNombre;
	
	@Column(columnDefinition = "text")
	private String usuCorreo;
	
	@Column(columnDefinition = "text")
	private String usuPassword;
	
	public long getUsuId() {
		return usuId;
	}
	
	public void setUsuId(long usuId) {
		this.usuId = usuId;
	}
	
	public String getUsuUsuario() {
		return usuUsuario;
	}
	
	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}
	
	public String getUsuNombre() {
		return usuNombre;
	}
	
	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}
	
	public String getUsuCorreo() {
		return usuCorreo;
	}
	
	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}
	
	public String getUsuPassword() {
		return usuPassword;
	}
	
	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}
	
	public Usuario(String usuUsuario, String usuNombre, String usuCorreo, String usuPassword) {
		super();
		this.usuUsuario = usuUsuario;
		this.usuNombre = usuNombre;
		this.usuCorreo = usuCorreo;
		this.usuPassword = usuPassword;
	}

	public Usuario() {
		super();
	}

}
