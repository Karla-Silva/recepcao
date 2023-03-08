package com.estacionamento.recepcao.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "Mensalista")
public class Mensalista {
    @Id
    private String placa;
    private String nome;
    private String cartaoDeCredito;
}
