package com.prueba.mesajeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.prueba.mesajeria.model.Registro;
import com.prueba.mesajeria.model.Vehiculo;
import com.prueba.mesajeria.repository.RegistroRepository;

@Controller
public class RegistroController {
	@Autowired
	private RegistroRepository repository;
	
	public Registro save(Vehiculo veh) {
		Registro registro = new Registro ();
		registro.setVehiculo(veh);
		registro.setLatitud(veh.getLatitud());
		registro.setLongitud(veh.getLongitud());
		return repository.save(registro);
	}
}
