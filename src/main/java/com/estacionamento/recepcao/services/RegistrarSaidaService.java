package com.estacionamento.recepcao.services;

import com.estacionamento.recepcao.payloads.request.SaidaRequest;
import com.estacionamento.recepcao.repositories.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarSaidaService {
    private final VagasRepository vagasRepository;

    public String execute(SaidaRequest saidaRequest){

        //financeiro informar valor

        vagasRepository.deleteByPlaca(saidaRequest.getPlaca());
        return "Carro devolvido";
    }
}