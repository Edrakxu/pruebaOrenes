package com.prueba.mesajeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.mensajeria.events.ActualizaEvent;
import com.prueba.mensajeria.events.UpdateEventListener;
import com.prueba.mensajeria.results.Resultado;
import com.prueba.mesajeria.controller.PedidosController;
import com.prueba.mesajeria.model.Estado;
import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Vehiculo;

@SpringBootTest
class EventTests {
	
	@Test
	void test() {
		UpdateEventListener events = new UpdateEventListener() {
			@Override
			public void onCoordenadaChange(ActualizaEvent ev) {
				// TODO Auto-generated method stub
				System.out.println("Se cambió las coordenadas");
			}
		};

        Vehiculo vehi = new Vehiculo();
        vehi.setLatitud(45);
        vehi.setLongitud(34);
 
        vehi.addUpdateEventListener(events);
 
        vehi.setLongitud(3412);
        vehi.setLatitud(434);
 
    
	}

}
