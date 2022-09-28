package com.prueba.mensajeria.validatos;

import java.util.ArrayList;

import com.prueba.mesajeria.model.Coordenadas;

public class CoordenadasValidator {

	public static String ERROR_LATITUD = "Es necesario insertar la laitud";
	public static String ERROR_LONGITUD = "Es necesario insertar la longitud";
	public static String ERROR_CORRDENADA = "Son necesarias la coordenadas";
	
	public static Validador validar(Coordenadas coord) {
		Validador validator = new Validador();
		ArrayList<String> mensajes = new ArrayList<String>();
		boolean estado = true;
		
		if(coord != null ) {
			if(coord.getLatitud() == 0){
				mensajes.add(ERROR_LATITUD);
			}
			
			if(coord.getLongitud() == 0){
				mensajes.add(ERROR_LONGITUD);
			}
			
		}else {
			mensajes.add(ERROR_CORRDENADA);
		}
		
		if(mensajes.size() > 0) {
			estado = false;
		}
		
		validator.setEstado(estado);
		validator.setMensajes(mensajes);
		return validator;
	}
}
