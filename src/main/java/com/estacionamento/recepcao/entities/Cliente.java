package com.estacionamento.recepcao.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String placa;
    private String nome;
}
