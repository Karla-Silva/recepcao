package com.estacionamento.recepcao.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Mensalista")
public class Mensalista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String placa;
    private String nome;
    private String cartaoDeCredito;
}
