package com.bike.api.rutas;

public class RutaResponse {

	private Long rutaId;
	private double rutaLatitudOrigen;
	private double rutaLongitudOrigen;
	private double rutaLatitudDestino;
	private double rutaLongitudDestino;
	private String rutaDescripcion;
	private int rutaPuntaje;
	
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
	
	public int getRutaPuntaje() {
		return rutaPuntaje;
	}
	
	public void setRutaPuntaje(int rutaPuntaje) {
		this.rutaPuntaje = rutaPuntaje;
	}

	public String getRutaDescripcion() {
		return rutaDescripcion;
	}

	public void setRutaDescripcion(String rutaDescripcion) {
		this.rutaDescripcion = rutaDescripcion;
	}
	 
}
