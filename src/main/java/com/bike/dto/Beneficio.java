package com.bike.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

import com.bike.dto.usuario.Usuario;

@Entity
@Table(name = "Beneficios")
public class Beneficio implements Serializable {
	
	 private static final long serialVersionUID = 4894729030347835498L;
	 
	 @Id
	 @GeneratedValue
	 private Long beneId;
	 private int beneCosto;
	 private String beneDescripcion;
	 
	 @ManyToMany
	 @JoinTable(
			 name = "HistorialBeneficios",
		     joinColumns = @JoinColumn(name = "FK_BENEFICIO", nullable = false),
		     inverseJoinColumns = @JoinColumn(name="FK_USUARIO", nullable = false)
		    )
	 
	 private Set<Usuario> usuarios;
		    
	 public Beneficio(){
			
		}
	 
	public Beneficio(Long beneId, int beneCosto, String beneDescripcion) {
		super();
		this.beneId = beneId;
		this.beneCosto = beneCosto;
		this.beneDescripcion = beneDescripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beneficio [beneId=");
		builder.append(beneId);
		builder.append(", beneCosto=");
		builder.append(beneCosto);
		builder.append(", beneDescripcion=");
		builder.append(beneDescripcion);
		builder.append("]");
		return builder.toString();
	}

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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	 
	
}
