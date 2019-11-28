package com.bike.dto.ruta;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bike.dto.usuario.Usuario;

@Entity
@Table(name = "Rutas")
public class Ruta implements Serializable {
	
	 private static final long serialVersionUID = 4894729030347835498L;
	 
	 @Id
	 @GeneratedValue
	 private Long rutaId;
	 private double rutaLatitudOrigen;
	 private double rutaLongitudOrigen;
	 private double rutaLatitudDestino;
	 private double rutaLongitudDestino;
	 private int rutaPuntaje;
	 private String rutaDescripcion;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "usu_id")
	 private Usuario usuario;
	 
	 private ArrayList<RutaPuntosIntermedios> rutaPuntosIntermedios;
	 
	 public Ruta(){
			
		}
	 
	public Ruta(Long rutaId, double rutaLatitudOrigen, double rutaLongitudOrigen, double rutaLatitudDestino,
			double rutaLongitudDestino, int rutaPuntaje, String rutaDescripcion, Usuario usuario,
			ArrayList<RutaPuntosIntermedios> rutaPuntosIntermedios) {
		super();
		this.rutaId = rutaId;
		this.rutaLatitudOrigen = rutaLatitudOrigen;
		this.rutaLongitudOrigen = rutaLongitudOrigen;
		this.rutaLatitudDestino = rutaLatitudDestino;
		this.rutaLongitudDestino = rutaLongitudDestino;
		this.rutaPuntaje = rutaPuntaje;
		this.rutaDescripcion = rutaDescripcion;
		this.usuario = usuario;
		this.rutaPuntosIntermedios = rutaPuntosIntermedios;
	}

	@Override
	public String toString() {
		return "Ruta [rutaId=" + rutaId + ", rutaLatitudOrigen=" + rutaLatitudOrigen + ", rutaLongitudOrigen="
				+ rutaLongitudOrigen + ", rutaLatitudDestino=" + rutaLatitudDestino + ", rutaLongitudDestino="
				+ rutaLongitudDestino + ", rutaPuntaje=" + rutaPuntaje + ", rutaDescripcion=" + rutaDescripcion
				+ ", usuario=" + usuario + ", rutaPuntosIntermedios=" + rutaPuntosIntermedios + "]";
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRutaDescripcion() {
		return rutaDescripcion;
	}

	public void setRutaDescripcion(String rutaDescripcion) {
		this.rutaDescripcion = rutaDescripcion;
	}

	public ArrayList<RutaPuntosIntermedios> getRutaPuntosIntermedios() {
		return rutaPuntosIntermedios;
	}

	public void setRutaPuntosIntermedios(ArrayList<RutaPuntosIntermedios> rutaPuntosIntermedios) {
		this.rutaPuntosIntermedios = rutaPuntosIntermedios;
	}
	
}
