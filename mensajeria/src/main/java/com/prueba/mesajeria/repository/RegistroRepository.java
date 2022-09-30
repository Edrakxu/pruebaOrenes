package com.prueba.mesajeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.mesajeria.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}
