package com.estacionamento.recepcao.repositories;

import com.estacionamento.recepcao.entities.Mensalista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensalistaRepository extends JpaRepository<Mensalista, String> {
}
