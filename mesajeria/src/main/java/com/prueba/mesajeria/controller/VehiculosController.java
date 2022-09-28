package com.prueba.mesajeria.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.mensajeria.constantes.Constantes;
import com.prueba.mensajeria.results.Resultado;
import com.prueba.mensajeria.validatos.CoordenadasValidator;
import com.prueba.mensajeria.validatos.Validador;
import com.prueba.mensajeria.validatos.VehiculoValidator;
import com.prueba.mesajeria.model.Coordenadas;
import com.prueba.mesajeria.model.Vehiculo;
import com.prueba.mesajeria.repository.RegistroRepository;
import com.prueba.mesajeria.repository.VehiculoRepository;
import com.prueba.mensajeria.utils.Utils;

@RestController
@RequestMapping("/vehiculos")
public class VehiculosController {
	
	@Autowired
	private VehiculoRepository repository;
	
	@Autowired
	private RegistroController registro;
	
	@GetMapping("/getPosicion/{id}")
	public Resultado getPosicion(@PathVariable("id") int id) {
		Resultado reslut = new Resultado();
		Vehiculo vehi  = repository.findById(id);
		if(vehi != null) {
			Coordenadas coord = new Coordenadas(vehi.getLatitud(),vehi.getLongitud());
			reslut.setValor(coord);
			reslut.setMensaje(Constantes.MSN_OK);
		}else {
			reslut.setMensaje(Constantes.POSI_NF);
		}
		
		return reslut;
	}
	
	@PostMapping("/add")
	public Resultado add(@RequestBody Vehiculo vehi) {
		Resultado reslut = new Resultado();
		//Validamos el vehiculo
		Validador vali =VehiculoValidator.validar(vehi);
		if(vali.isEstado()) {
			reslut.setValor(repository.save(vehi));
			reslut.setMensaje(Constantes.MSN_OK);
		}else {
			reslut.setMensaje(Utils.generaMesaje(vali.getMensajes()));
		}
		
		return reslut;
	}
	
	@PutMapping("/update/{id}")
	public Resultado update(@PathVariable int id ,@RequestBody Vehiculo vehi) {
		Resultado reslut = new Resultado();
		//Validamos el vehiculo
		Validador vali =VehiculoValidator.validar(vehi);
		if(vali.isEstado()) {
			Vehiculo vehiculo = repository.findById(id);
			if(vehiculo!= null){
				vehi.setId(id);
				reslut.setValor(repository.save(vehi));
				reslut.setMensaje(Constantes.MSN_OK);
			}
		}else {
			reslut.setMensaje(Utils.generaMesaje(vali.getMensajes()));
		}
		
		return reslut;
	}
	
	@PutMapping("/updatePosicion/{id}")
	public Resultado updatePosicion(@PathVariable int id ,@RequestBody Coordenadas cord) {
		Resultado reslut = new Resultado();
		//Validamos el vehiculo
		Validador vali =CoordenadasValidator.validar(cord);
		if(vali.isEstado()) {
			Vehiculo vehiculo = repository.findById(id);
			if(vehiculo!= null){
				vehiculo.setLatitud(cord.getLatitud());
				vehiculo.setLongitud(cord.getLongitud());
				reslut.setValor(repository.save(vehiculo));
				reslut.setMensaje(Constantes.MSN_OK);
				//Se registra el cambio de coordenadas
				registro.save(vehiculo);
			}
		}else {
			reslut.setMensaje(Utils.generaMesaje(vali.getMensajes()));
		}
		
		return reslut;
	}
	
}
