package com.bike.dto.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class UsuarioCiudadano extends Usuario {
	
	@Column(columnDefinition = "text")
    private String usuTipoIdentificacion;
	
	@Column(columnDefinition = "text")
    private String usuNumIdentificacion;
	
	@Column(columnDefinition = "text")
    private String usuTelefono;
	
	@Column(columnDefinition = "text")
    private String usuDireccion;
	
	@Column(columnDefinition = "text")
    private String usuEmpresa;
	
	public UsuarioCiudadano() {
		super();
	}
	
	public UsuarioCiudadano(String usuUsuario, String usuNombre, String usuCorreo, String usuPassword,
			String usuTipoIdentificacion, String usuNumIdentificacion, String usuTelefono, String usuDireccion, String usuEmpresa) {
		super(usuUsuario, usuNombre, usuCorreo, usuPassword);
		this.usuTipoIdentificacion = usuTipoIdentificacion;
		this.usuNumIdentificacion = usuNumIdentificacion;
		this.usuTelefono = usuTelefono;
		this.usuDireccion = usuDireccion;
		this.usuEmpresa = usuEmpresa;
	}

	public String getUsuTipoIdentificacion() {
		return usuTipoIdentificacion;
	}

	public void setUsuTipoIdentificacion(String usuTipoIdentificacion) {
		this.usuTipoIdentificacion = usuTipoIdentificacion;
	}

	public String getUsuNumIdentificacion() {
		return usuNumIdentificacion;
	}

	public void setUsuNumIdentificacion(String usuNumIdentificacion) {
		this.usuNumIdentificacion = usuNumIdentificacion;
	}

	public String getUsuTelefono() {
		return usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

	public String getUsuDireccion() {
		return usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
	}

	public String getUsuEmpresa() {
		return usuEmpresa;
	}

	public void setUsuEmpresa(String usuEmpresa) {
		this.usuEmpresa = usuEmpresa;
	}
	
}
