package com.bike.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReportesRobo")
public class Robo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roboId;
	// private long roboBicicletaId;
	private String roboCoordLatitud;
	private String roboCoordLongitud;
	private String roboDescripcion;
	private String roboFecha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bici_id")
	private Bicicleta bicicleta;
	
		
	public long getRoboId() {
		return roboId;
	}
	public void setRoboId(long roboId) {
		this.roboId = roboId;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
	public String getRoboCoordLatitud() {
		return roboCoordLatitud;
	}
	public void setRoboCoordLatitud(String roboCoordLatitud) {
		this.roboCoordLatitud = roboCoordLatitud;
	}
	public String getRoboCoordLongitud() {
		return roboCoordLongitud;
	}
	public void setRoboCoordLongitud(String roboCoordLongitud) {
		this.roboCoordLongitud = roboCoordLongitud;
	}
	public String getRoboDescripcion() {
		return roboDescripcion;
	}
	public void setRoboDescripcion(String roboDescripcion) {
		this.roboDescripcion = roboDescripcion;
	}
	public String getRoboFecha() {
		return roboFecha;
	}
	public void setRoboFecha(String roboFecha) {
		this.roboFecha = roboFecha;
	}
	
	
}
