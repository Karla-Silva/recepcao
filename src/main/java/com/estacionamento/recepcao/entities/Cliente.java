package com.estacionamento.recepcao.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "cliente")
public class Cliente {
    @Id
    private String placa;
    private String nome;
}
