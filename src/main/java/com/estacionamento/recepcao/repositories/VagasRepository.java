package com.estacionamento.recepcao.repositories;

import com.estacionamento.recepcao.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagasRepository extends JpaRepository<Cliente, String> {
}
