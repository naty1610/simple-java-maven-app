package com.bike.api.robo;

public class RequestRobo {
	private long bicicletaId;
	private String coordLatitud;
	private String coordLongitud;
	private String descripcion;
	private String fecha;
	private String tipoAplicacion;
	
	
	public long getBicicletaId() {
		return bicicletaId;
	}
	public void setBicicletaId(long bicicletaId) {
		this.bicicletaId = bicicletaId;
	}
	public String getCoordLatitud() {
		return coordLatitud;
	}
	public void setCoordLatitud(String coordLatitud) {
		this.coordLatitud = coordLatitud;
	}
	public String getCoordLongitud() {
		return coordLongitud;
	}
	public void setCoordLongitud(String coordLongitud) {
		this.coordLongitud = coordLongitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoAplicacion() {
		return tipoAplicacion;
	}
	public void setTipoAplicacion(String tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}
	
	

}
