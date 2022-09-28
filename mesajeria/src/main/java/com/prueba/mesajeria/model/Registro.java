package com.prueba.mesajeria.model;

import java.util.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registro_ubicacion")
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_registro")
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	@Column(name="hora_registro")
	private Date horaRegistro;
	private double latitud;
	private double longitud;
	
	public Registro() {
		super();
		this.horaRegistro = new Date();
	}
	
	public Registro(int id, Vehiculo vehiculo, Date horaRegistro, double latitud, double longitud) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.horaRegistro = new Date();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getHoraRegistro() {
		return horaRegistro;
	}
	public void setHoraRegistro(Date horaRegistro) {
		this.horaRegistro = horaRegistro;
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
