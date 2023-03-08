package com.estacionamento.recepcao.payloads.request;

import lombok.Data;

@Data
public class SaidaRequest {
    private String placa;
    private int quantidadeDeHoras;
}
