package com.estacionamento.recepcao.services;

import com.estacionamento.recepcao.client.OcuparVagaMensalistaClient;
import com.estacionamento.recepcao.client.VagasMensalistasClient;
import com.estacionamento.recepcao.entities.Cliente;
import com.estacionamento.recepcao.entities.Mensalista;
import com.estacionamento.recepcao.payloads.request.CadastrarMensalistaRequest;
import com.estacionamento.recepcao.payloads.request.VagaRequest;
import com.estacionamento.recepcao.repositories.MensalistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CadastrarMensalistaService {
    private final MensalistaRepository mensalistaRepository;
    private final VagasMensalistasClient vagasMensalistasClient;
    private final OcuparVagaMensalistaClient ocuparVagaMensalistaClient;
    private String retorno;

    public String execute(CadastrarMensalistaRequest cadastrarMensalistaRequest){
        Mono<Boolean> temVaga = vagasMensalistasClient.consultarVagasMensalistas();
        temVaga.subscribe(
                vaga -> {if(vaga.booleanValue()){
                    Mensalista mensalista = new Mensalista();
                    mensalista.setPlaca(cadastrarMensalistaRequest.getPlaca());
                    mensalista.setNome(cadastrarMensalistaRequest.getNome());
                    mensalista.setCartaoDeCredito(cadastrarMensalistaRequest.getCartaoDeCredito());
                    mensalistaRepository.save(mensalista);
                    VagaRequest vagaRequest = new VagaRequest();
                    vagaRequest.setPlaca(cadastrarMensalistaRequest.getPlaca());
                    ocuparVagaMensalistaClient.ocuparVagaMensalista(vagaRequest);

                    //financeiro cadastrar mensalista

                    retorno = "Cadastro realizado";
                }else{retorno="Não há vagas para mensalistas.";}
                }
        );
        return retorno;
    };
}
