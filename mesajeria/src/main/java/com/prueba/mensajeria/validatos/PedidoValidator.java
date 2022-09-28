package com.prueba.mensajeria.validatos;

import java.util.ArrayList;

import com.prueba.mesajeria.model.Pedido;

public class PedidoValidator {
	public static String ERROR_NOMBRE = "Es necesario insertar el nombre";
	public static String ERROR_PEDIDO = "Es necesario el pedido";
	public static String ERROR_VEHICULO = "Es necesario el vehiculo asociado";
	public static String ERROR_VEHICULO_ID = "El id del vehiculo es incorrecto";
	public static String ERROR_ESTADO= "Es necesario el estado asociado";
	public static String ERROR_ESTADO_ID= "El id del estado es incorrecto";
	
	public static Validador validar(Pedido pediddo) {
		Validador validator = new Validador();
		ArrayList<String> mensajes = new ArrayList<String>();
		boolean estado = true;
		
		if(pediddo != null ) {
			if(pediddo.getProducto() == null){
				mensajes.add(ERROR_NOMBRE);
			}
			if(pediddo.getVehiculo() == null){
				mensajes.add(ERROR_VEHICULO);
			}else {
				if(pediddo.getVehiculo().getId() == -1) {
					mensajes.add(ERROR_VEHICULO_ID);
				}
			}
			if(pediddo.getEstado() == null){
				mensajes.add(ERROR_ESTADO);
			}else {
				if(pediddo.getEstado().getId() == -1) {
					mensajes.add(ERROR_ESTADO_ID);
				}
			}
		}else {
			mensajes.add(ERROR_PEDIDO);
		}
		
		if(mensajes.size() > 0) {
			estado = false;
		}
		
		validator.setEstado(estado);
		validator.setMensajes(mensajes);
		return validator;
	}
}
