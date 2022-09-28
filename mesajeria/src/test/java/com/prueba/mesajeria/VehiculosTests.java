package com.prueba.mesajeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.mensajeria.results.Resultado;
import com.prueba.mesajeria.controller.VehiculosController;
import com.prueba.mesajeria.model.Coordenadas;
import com.prueba.mesajeria.model.Vehiculo;

@SpringBootTest
class VehiculosTests {
	
	@Autowired
	 private VehiculosController controller;
	
	@Test
	void add() {
		Vehiculo vehi1 = new Vehiculo();
		vehi1.setResponsable("Prueba1");
		//Correcto
		Resultado res1 = controller.add(vehi1);
		assertThat(res1.getValor()).isNotNull();
		
		Vehiculo vehi2 = new Vehiculo();
		//Error
		Resultado res2 = controller.add(vehi2);
		assertThat(res2.getValor()).isNull();
		
	}
	
	@Test
	void update() {
		Vehiculo vehi1 = new Vehiculo();
		vehi1.setResponsable("Prueba update 1");
		//Correcto
		Resultado res1 = controller.update(1,vehi1);
		assertThat(res1.getValor()).isNotNull();
		
		Vehiculo vehi2 = new Vehiculo();
		vehi1.setResponsable("Prueba update 2");
		//Error
		Resultado res2 = controller.update(-1,vehi2);
		assertThat(res2.getValor()).isNull();
		
	}
	
	@Test
	void updatePosicion() {
		Coordenadas coor = new Coordenadas(35,47);
		//Correcto
		Resultado res1 = controller.updatePosicion(1,coor);
		assertThat(res1.getValor()).isNotNull();
		
		Coordenadas coor2 = new Coordenadas();
		//Error
		Resultado res2 = controller.updatePosicion(1,coor2);
		assertThat(res2.getValor()).isNull();
		
	}
	
	@Test
	void getPosicion() {
		//Correcto
		Resultado res1 = controller.getPosicion(1);
		assertThat(res1.getValor()).isNotNull();
		
		//Error
		Resultado res2 = controller.getPosicion(-1);
		assertThat(res2.getValor()).isNull();
		
	}

}
