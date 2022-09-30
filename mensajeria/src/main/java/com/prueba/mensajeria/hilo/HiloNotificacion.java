package com.prueba.mensajeria.hilo;

import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Usuario;
import com.prueba.mesajeria.model.Vehiculo;
import com.prueba.mesajeria.repository.PedidoRepository;
import com.prueba.mesajeria.repository.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class HiloNotificacion extends Thread {
	Vehiculo vehi;

	private PedidoRepository repository;
	
	public void run() 
    {	
		List<Pedido> pedidos =  repository.findByVehiculoId(1);
		for (Pedido pedido : pedidos) {
			Usuario usu = pedido.getUsuario();
			Vehiculo vehiculo = pedido.getVehiculo();
			System.out.print("Se envia a "+usu.getNombre()+" al email: "+usu.getEmail()+" las coordenadas: "+vehiculo.getLatitud()+","+vehiculo.getLongitud());
			//Aqui simulamos el envio a la app y la web
		}
        
    }
	
	public void setVehiculo(Vehiculo vehi) {
		this.vehi = vehi;
	}

	public void setRepositoryPedido(PedidoRepository repository) {
		this.repository = repository;
	}	
	
}
