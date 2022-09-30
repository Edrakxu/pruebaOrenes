package com.prueba.mesajeria.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.mesajeria.model.Pedido;
import com.prueba.mesajeria.model.Usuario;

public  interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findById(int id);

}
