package com.prueba.mesajeria.model;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.prueba.mensajeria.events.ActualizaEvent;
import com.prueba.mensajeria.events.UpdateEventListener;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_usu")
	private int id;
	private String nombre;
	private String email;
	

	public Usuario() {
		super();
	}
	
	public Usuario(int id) {
		super();
		this.id = id;
	}
	
	public Usuario(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
