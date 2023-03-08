package com.estacionamento.recepcao.client;

import com.estacionamento.recepcao.payloads.request.VagaRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OcuparVagaMensalistaClient {
    @Value("http://localhost:9081/patio/ocuparvagamensalista")
    private String requestAdress;

    public void ocuparVagaMensalista(VagaRequest vagaRequest){
        WebClient webClient = WebClient.create();
        webClient.post().uri(requestAdress)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(vagaRequest))
                .retrieve()
                .bodyToMono(Void.class);
    }
}
