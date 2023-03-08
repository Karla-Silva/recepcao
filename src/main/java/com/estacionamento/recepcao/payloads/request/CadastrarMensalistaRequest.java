package com.estacionamento.recepcao.payloads.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CadastrarMensalistaRequest {
    @NotNull
    private String nome;
    @NotNull
    private String placa;
    @NotNull
    private String cartaoDeCredito;
}
