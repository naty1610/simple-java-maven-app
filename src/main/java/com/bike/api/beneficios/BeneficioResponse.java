package com.bike.api.beneficios;

public class BeneficioResponse {

	private Long beneId;
	private int beneCosto;
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
