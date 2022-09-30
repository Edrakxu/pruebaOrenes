package com.prueba.mesajeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id
	@Column(name="id_estado")
	private int id;
	private String estado;
	
	public Estado() {
		super();
	}
	
	public Estado(int id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	
	public Estado(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
