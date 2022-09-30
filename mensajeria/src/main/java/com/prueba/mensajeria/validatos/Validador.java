package com.prueba.mensajeria.validatos;

import java.util.ArrayList;

public class Validador {
	private boolean estado;
	private ArrayList<String> mensajes;
	
	public Validador() {
		super();
	}	
	public Validador(boolean estado, ArrayList<String> mensajes) {
		super();
		this.estado = estado;
		this.mensajes = mensajes;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public ArrayList<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(ArrayList<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
