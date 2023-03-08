package com.estacionamento.recepcao.services;

import com.estacionamento.recepcao.client.OcuparVagaClient;
import com.estacionamento.recepcao.client.VagasClient;
import com.estacionamento.recepcao.entities.Cliente;
import com.estacionamento.recepcao.payloads.request.ReceberClienteRequest;
import com.estacionamento.recepcao.payloads.request.VagaRequest;
import com.estacionamento.recepcao.repositories.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReceberClienteService {
    private final VagasRepository vagasRepository;
    private final VagasClient vagasClient;
    private final OcuparVagaClient ocuparVagaClient;
    private String retorno;

    public String execute(ReceberClienteRequest receberClienteRequest){
        Mono<Boolean> temVaga = vagasClient.consultarVagas();
        temVaga.subscribe(
            vaga -> {if(vaga.booleanValue()){
                Cliente cliente = new Cliente();
                cliente.setPlaca(receberClienteRequest.getPlaca());
                cliente.setNome(receberClienteRequest.getNome());
                vagasRepository.save(cliente);
                VagaRequest vagaRequest = new VagaRequest();
                vagaRequest.setPlaca(receberClienteRequest.getPlaca());
                ocuparVagaClient.ocuparVaga(vagaRequest);
                retorno = "Carro guardado";
            }else{retorno="Não há vagas.";}
            }
        );
        return retorno;
    };
}
