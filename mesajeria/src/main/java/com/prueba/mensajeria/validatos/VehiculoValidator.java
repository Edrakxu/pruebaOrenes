package com.prueba.mensajeria.validatos;

import java.util.ArrayList;

import com.prueba.mesajeria.model.Vehiculo;

public class VehiculoValidator {
	
	public static String ERROR_NOMBRE = "Es necesario insertar el nombre";
	public static String ERROR_VEHICULO = "Es necesario el vehiculo";
	
	public static Validador validar(Vehiculo vehi) {
		Validador validator = new Validador();
		ArrayList<String> mensajes = new ArrayList<String>();
		boolean estado = true;
		
		if(vehi != null ) {
			if(vehi.getResponsable() == null){
				mensajes.add(ERROR_NOMBRE);
			}
			
		}else {
			mensajes.add(ERROR_VEHICULO);
		}
		
		if(mensajes.size() > 0) {
			estado = false;
		}
		
		validator.setEstado(estado);
		validator.setMensajes(mensajes);
		return validator;
	}
}
