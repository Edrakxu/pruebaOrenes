package com.prueba.mesajeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.mensajeria.constantes.Constantes;
import com.prueba.mensajeria.results.Resultado;
import com.prueba.mensajeria.utils.Utils;
import com.prueba.mensajeria.validatos.PedidoValidator;
import com.prueba.mensajeria.validatos.Validador;
import com.prueba.mensajeria.validatos.VehiculoValidator;
import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Vehiculo;
import com.prueba.mesajeria.repository.PedidoRepository;
import com.prueba.mesajeria.repository.VehiculoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidoRepository repository;
	
	@PostMapping("/add")
	public Resultado add(@RequestBody Pedido pedido) {
		Resultado reslut = new Resultado();
		//Validamos el pedido
		Validador vali =PedidoValidator.validar(pedido);
		if(vali.isEstado()) {
			reslut.setValor(repository.save(pedido));
			reslut.setMensaje(Constantes.MSN_OK);
		}else {
			reslut.setMensaje(Utils.generaMesaje(vali.getMensajes()));
		}
		
		return reslut;
	}
	
	@DeleteMapping("/delete/{id}")
	public Resultado delete(@PathVariable int id) {
		Resultado reslut = new Resultado();
		Long log =repository.deleteById(id);
		
		if(log > 0) {
			reslut.setValor(true);
			reslut.setMensaje(Constantes.MSN_OK);
		}else {
			reslut.setValor(false);
			reslut.setMensaje(Constantes.PEDI_NDELETE);
		}
		
		return reslut;
	}
}
