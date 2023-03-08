package com.estacionamento.recepcao.services;

import com.estacionamento.recepcao.payloads.request.CadastrarMensalistaRequest;
import com.estacionamento.recepcao.repositories.MensalistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarMensalistaService {
    private final MensalistaRepository mensalistaRepository;

    public String execute(CadastrarMensalistaRequest cadastrarMensalistaRequest){
        //consultar vagas mensalistas no pátio

        return "Cadastro realizado com sucesso";
    };
}
