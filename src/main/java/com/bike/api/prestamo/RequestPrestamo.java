package com.bike.api.prestamo;

public class RequestPrestamo {
	
	private long idBicicleta;
	private long idUsuario;
	private String fechaInicio;
	private String fechaFin;
	private long costo;
	private String tipoAplicacion;
	
	public long getIdBicicleta() {
		return idBicicleta;
	}
	public void setIdBicicleta(long idBicicleta) {
		this.idBicicleta = idBicicleta;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipoAplicacion() {
		return tipoAplicacion;
	}
	public void setTipoAplicacion(String tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}
	public long getCosto() {
		return costo;
	}
	public void setCosto(long costo) {
		this.costo = costo;
	}
	
	
}
