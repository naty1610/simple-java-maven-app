package com.bike.api.rutas;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.bike.dto.ruta.RutaPuntosIntermedios;
import com.bike.dto.usuario.Usuario;

public class RutaRequest {

	private Long rutaId;
	
	@NotNull(message="Campo requerido")
	private double rutaLatitudOrigen;
	
	@NotNull(message="Campo requerido")
	private double rutaLongitudOrigen;
	
	@NotNull(message="Campo requerido")
	private double rutaLatitudDestino;
	
	@NotNull(message="Campo requerido")
	private double rutaLongitudDestino;

	private String rutaDescripcion;
	
	private Usuario usuario;
	
	private ArrayList<RutaPuntosIntermedios> rutaPuntosIntermedios;
	
	public Long getRutaId() {
		return rutaId;
	}

	public void setRutaId(Long rutaId) {
		this.rutaId = rutaId;
	}

	public double getRutaLatitudOrigen() {
		return rutaLatitudOrigen;
	}

	public void setRutaLatitudOrigen(double rutaLatitudOrigen) {
		this.rutaLatitudOrigen = rutaLatitudOrigen;
	}

	public double getRutaLongitudOrigen() {
		return rutaLongitudOrigen;
	}

	public void setRutaLongitudOrigen(double rutaLongitudOrigen) {
		this.rutaLongitudOrigen = rutaLongitudOrigen;
	}

	public double getRutaLatitudDestino() {
		return rutaLatitudDestino;
	}

	public void setRutaLatitudDestino(double rutaLatitudDestino) {
		this.rutaLatitudDestino = rutaLatitudDestino;
	}

	public double getRutaLongitudDestino() {
		return rutaLongitudDestino;
	}

	public void setRutaLongitudDestino(double rutaLongitudDestino) {
		this.rutaLongitudDestino = rutaLongitudDestino;
	}

	public String getRutaDescripcion() {
		return rutaDescripcion;
	}

	public void setRutaDescripcion(String rutaDescripcion) {
		this.rutaDescripcion = rutaDescripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<RutaPuntosIntermedios> getRutaPuntosIntermedios() {
		return rutaPuntosIntermedios;
	}

	public void setRutaPuntosIntermedios(ArrayList<RutaPuntosIntermedios> rutaPuntosIntermedios) {
		this.rutaPuntosIntermedios = rutaPuntosIntermedios;
	}

	/*
	public int getRutaPuntaje() {
		return rutaPuntaje;
	}

	public void setRutaPuntaje(int rutaPuntaje) {
		this.rutaPuntaje = rutaPuntaje;
	}*/
	
}
