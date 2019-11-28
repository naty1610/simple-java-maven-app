package com.bike.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bike.dto.usuario.Usuario;

@Entity
@Table(name = "Prestamos")
public class Prestamo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long prestId;
	private String prestFechaInicio;
	private String prestFechaFin;
	private long prestCosto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bici_id")
	private Bicicleta bicicleta;
	
	public long getPrestId() {
		return prestId;
	}
	public void setPrestId(long prestId) {
		this.prestId = prestId;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
	public String getPrestFechaInicio() {
		return prestFechaInicio;
	}
	public void setPrestFechaInicio(String prestFechaInicio) {
		this.prestFechaInicio = prestFechaInicio;
	}
	public String getPrestFechaFin() {
		return prestFechaFin;
	}
	public void setPrestFechaFin(String prestFechaFin) {
		this.prestFechaFin = prestFechaFin;
	}
	public long getPrestCosto() {
		return prestCosto;
	}
	public void setPrestCosto(long prestCosto) {
		this.prestCosto = prestCosto;
	}
	
	
}
