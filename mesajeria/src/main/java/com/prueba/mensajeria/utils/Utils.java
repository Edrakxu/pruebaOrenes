package com.prueba.mensajeria.utils;

import java.util.ArrayList;
import java.util.Date;

public class Utils {
	
	public static String generaMesaje(ArrayList<String> mensajes) {
		StringBuffer mensaje = new StringBuffer();
		
		for(int i=0; i < mensajes.size();i++) {
			mensaje.append(mensajes.get(i));
		}
		
		return mensaje.toString();
	}
}
