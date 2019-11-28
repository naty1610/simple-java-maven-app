package com.bike.api.beneficios;

import javax.validation.constraints.NotNull;

public class BeneficioRequest {

	private Long beneId;
	
	@NotNull(message="El costo es requerido")
	private int beneCosto;
	
	@NotNull(message="La descripción es requerida")
	private String beneDescripcion;

	public Long getBeneId() {
		return beneId;
	}

	public void setBeneId(Long beneId) {
		this.beneId = beneId;
	}

	public int getBeneCosto() {
		return beneCosto;
	}

	public void setBeneCosto(int beneCosto) {
		this.beneCosto = beneCosto;
	}

	public String getBeneDescripcion() {
		return beneDescripcion;
	}

	public void setBeneDescripcion(String beneDescripcion) {
		this.beneDescripcion = beneDescripcion;
	}
	
}
