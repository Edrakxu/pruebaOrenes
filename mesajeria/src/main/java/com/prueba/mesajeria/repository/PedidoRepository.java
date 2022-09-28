package com.prueba.mesajeria.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.mesajeria.model.Pedido;

public  interface PedidoRepository extends JpaRepository<Pedido, Long>{
	@Transactional
	Long deleteById(int id);

}
