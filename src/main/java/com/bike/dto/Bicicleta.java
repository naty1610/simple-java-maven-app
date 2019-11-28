package com.bike.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bike.dto.usuario.Usuario;


@Entity
@Table(name = "Bicicletas")
public class Bicicleta {
	@Id
	@GeneratedValue
	private long biciId;
	private String biciCodigo;
	private String biciModelo;
	private String biciMarca;
	private String biciColor;
	private String biciSerial;
	private Date biciFechaCompra;
	private long biciValorComercial;
	private String bicifoto;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	public Bicicleta() {}
	
	
	
	public Bicicleta(long biciId, String biciCodigo, String biciModelo, String biciMarca, String biciColor,
			String biciSerial, Date biciFechaCompra, long biciValorComercial, String bicifoto, Usuario usuario) {
		super();
		this.biciId = biciId;
		this.biciCodigo = biciCodigo;
		this.biciModelo = biciModelo;
		this.biciMarca = biciMarca;
		this.biciColor = biciColor;
		this.biciSerial = biciSerial;
		this.biciFechaCompra = biciFechaCompra;
		this.biciValorComercial = biciValorComercial;
		this.bicifoto = bicifoto;
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Bicicleta [biciId=" + biciId + ", biciCodigo=" + biciCodigo + ", biciModelo=" + biciModelo
				+ ", biciMarca=" + biciMarca + ", biciColor=" + biciColor + ", biciSerial=" + biciSerial
				+ ", biciFechaCompra=" + biciFechaCompra + ", biciValorComercial=" + biciValorComercial + ", bicifoto="
				+ bicifoto + ", usuario=" + usuario + "]";
	}
	
	
	public long getBiciId() {
		return biciId;
	}



	public void setBiciId(long biciId) {
		this.biciId = biciId;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getBiciCodigo() {
		return biciCodigo;
	}

	public void setBiciCodigo(String biciCodigo) {
		this.biciCodigo = biciCodigo;
	}

	public String getBiciModelo() {
		return biciModelo;
	}

	public void setBiciModelo(String biciModelo) {
		this.biciModelo = biciModelo;
	}

	public String getBiciMarca() {
		return biciMarca;
	}

	public void setBiciMarca(String biciMarca) {
		this.biciMarca = biciMarca;
	}

	public String getBiciColor() {
		return biciColor;
	}

	public void setBiciColor(String biciColor) {
		this.biciColor = biciColor;
	}

	public String getBiciSerial() {
		return biciSerial;
	}

	public void setBiciSerial(String biciSerial) {
		this.biciSerial = biciSerial;
	}

	public Date getBiciFechaCompra() {
		return biciFechaCompra;
	}

	public void setBiciFechaCompra(Date biciFechaCompra) {
		this.biciFechaCompra = biciFechaCompra;
	}

	public long getBiciValorComercial() {
		return biciValorComercial;
	}

	public void setBiciValorComercial(long biciValorComercial) {
		this.biciValorComercial = biciValorComercial;
	}

	public String getBicifoto() {
		return bicifoto;
	}

	public void setBicifoto(String bicifoto) {
		this.bicifoto = bicifoto;
	}

}
