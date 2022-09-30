package com.prueba.mesajeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.mensajeria.results.Resultado;
import com.prueba.mesajeria.controller.PedidosController;
import com.prueba.mesajeria.model.Estado;
import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Vehiculo;

@SpringBootTest
class PedidosTests {
	
	@Autowired
	 private PedidosController controller;
	
	@Test
	void add() {
		//Correcto
		Pedido pedido1 = new Pedido();
		pedido1.setProducto("Producto Prueba");
		pedido1.setVehiculo(new Vehiculo(1));
		pedido1.setEstado(new Estado(1));
		Resultado res1 = controller.add(pedido1);
		assertThat(res1.getValor()).isNotNull();
		
		//Error
		Pedido pedido2 = new Pedido();
		pedido2.setVehiculo(new Vehiculo(1));
		pedido2.setEstado(new Estado(1));
		Resultado res2 = controller.add(pedido2);
		assertThat(res2.getValor()).isNull();
		
	}
	
	@Test
	void delete() {
		
		//Correcto
		Resultado res1 = controller.delete(12);
		assertThat(res1.getValor()).isEqualTo(true);
		
		//Error
		Resultado res2 = controller.delete(-1);
		assertThat(res2.getValor()).isEqualTo(false);
		
	}

}
