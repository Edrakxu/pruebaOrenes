package com.prueba.mesajeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_vehiculo")
	private int id;
	private String responsable;
	@Transient
	private Coordenadas coordenadas;
	private double latitud;
	private double longitud;
	
	public Vehiculo() {
		super();
		
	}
	
	public Vehiculo(int id) {
		super();
		this.id = id;
	}
	
	public Vehiculo(int id, String resposable, double latitud, double longitud) {
		super();
		this.id = id;
		this.responsable = resposable;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public int getId() {
		return id;
	}
	public void setId(int id_vehiculo) {
		this.id = id_vehiculo;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String resposable) {
		this.responsable = resposable;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
}
