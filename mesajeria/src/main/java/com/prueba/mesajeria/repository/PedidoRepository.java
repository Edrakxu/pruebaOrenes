package com.prueba.mesajeria.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Usuario;

public  interface PedidoRepository extends JpaRepository<Pedido, Long>{
	@Transactional
	Long deleteById(int id);
	
	List<Pedido> findByVehiculoId(int vehiculo);

}
