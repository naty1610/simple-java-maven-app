package com.bike.dto;

import java.io.Serializable;

import javax.persistence.*;

import com.bike.dto.usuario.Usuario;

@Entity
@Table(name = "Monitoreo")
public class Monitoreo implements Serializable {
	
	 private static final long serialVersionUID = 4894729030347835498L;
	 
	 @Id
	 @GeneratedValue
	 private Long monitorId;
	 private double monitorDistanciaDia;
	 private double monitorDistanciaSemana;
	 private double monitorDistanciaMes;
	 private int monitorPuntos;
	 private double monitorTiempoDia;
	 private double monitorTiempoSemana;
	 private double monitorTiempoMes;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "usu_id")
	    private Usuario usuario;

	public Monitoreo(Long monitorId, double monitorDistanciaDia, double monitorDistanciaSemana,
			double monitorDistanciaMes, int monitorPuntos, double monitorTiempoDia, double monitorTiempoSemana,
			double monitorTiempoMes, Usuario usuario) {
		super();
		this.monitorId = monitorId;
		this.monitorDistanciaDia = monitorDistanciaDia;
		this.monitorDistanciaSemana = monitorDistanciaSemana;
		this.monitorDistanciaMes = monitorDistanciaMes;
		this.monitorPuntos = monitorPuntos;
		this.monitorTiempoDia = monitorTiempoDia;
		this.monitorTiempoSemana = monitorTiempoSemana;
		this.monitorTiempoMes = monitorTiempoMes;
		this.usuario = usuario;
	}

	public Monitoreo() {
		super();
	}

	public Long getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public double getMonitorDistanciaDia() {
		return monitorDistanciaDia;
	}

	public void setMonitorDistanciaDia(double monitorDistanciaDia) {
		this.monitorDistanciaDia = monitorDistanciaDia;
	}

	public double getMonitorDistanciaSemana() {
		return monitorDistanciaSemana;
	}

	public void setMonitorDistanciaSemana(double monitorDistanciaSemana) {
		this.monitorDistanciaSemana = monitorDistanciaSemana;
	}

	public double getMonitorDistanciaMes() {
		return monitorDistanciaMes;
	}

	public void setMonitorDistanciaMes(double monitorDistanciaMes) {
		this.monitorDistanciaMes = monitorDistanciaMes;
	}

	public int getMonitorPuntos() {
		return monitorPuntos;
	}

	public void setMonitorPuntos(int monitorPuntos) {
		this.monitorPuntos = monitorPuntos;
	}

	public double getMonitorTiempoDia() {
		return monitorTiempoDia;
	}

	public void setMonitorTiempoDia(double monitorTiempoDia) {
		this.monitorTiempoDia = monitorTiempoDia;
	}

	public double getMonitorTiempoSemana() {
		return monitorTiempoSemana;
	}

	public void setMonitorTiempoSemana(double monitorTiempoSemana) {
		this.monitorTiempoSemana = monitorTiempoSemana;
	}

	public double getMonitorTiempoMes() {
		return monitorTiempoMes;
	}

	public void setMonitorTiempoMes(double monitorTiempoMes) {
		this.monitorTiempoMes = monitorTiempoMes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Monitoreo [monitorId=" + monitorId + ", monitorDistanciaDia=" + monitorDistanciaDia
				+ ", monitorDistanciaSemana=" + monitorDistanciaSemana + ", monitorDistanciaMes=" + monitorDistanciaMes
				+ ", monitorPuntos=" + monitorPuntos + ", monitorTiempoDia=" + monitorTiempoDia
				+ ", monitorTiempoSemana=" + monitorTiempoSemana + ", monitorTiempoMes=" + monitorTiempoMes
				+ ", usuario=" + usuario + "]";
	}

	

}
