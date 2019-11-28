package com.bike.dto.ruta;

import java.io.Serializable;

public class RutaPuntosIntermedios implements Serializable {
	
	 private static final long serialVersionUID = 4894729030347835498L;
	
	 private double puntIntCoordLatitud;
	 private double puntIntCoordLongitud;
	 
	 public RutaPuntosIntermedios(){
			
		}

	public RutaPuntosIntermedios(double puntIntCoordLatitud, double puntIntCoordLongitud) {
		super();
		this.puntIntCoordLatitud = puntIntCoordLatitud;
		this.puntIntCoordLongitud = puntIntCoordLongitud;
	}

	@Override
	public String toString() {
		return "RutaPuntosIntermedios [puntIntCoordLatitud=" + puntIntCoordLatitud
				+ ", puntIntCoordLongitud=" + puntIntCoordLongitud + "]";
	}

	public double getPuntIntCoordLatitud() {
		return puntIntCoordLatitud;
	}

	public void setPuntIntCoordLatitud(double puntIntCoordLatitud) {
		this.puntIntCoordLatitud = puntIntCoordLatitud;
	}

	public double getPuntIntCoordLongitud() {
		return puntIntCoordLongitud;
	}

	public void setPuntIntCoordLongitud(double puntIntCoordLongitud) {
		this.puntIntCoordLongitud = puntIntCoordLongitud;
	}

}
