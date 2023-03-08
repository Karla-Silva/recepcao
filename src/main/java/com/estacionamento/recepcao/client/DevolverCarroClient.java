package com.estacionamento.recepcao.client;

import com.estacionamento.recepcao.payloads.request.VagaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class DevolverCarroClient {
    @Value("http://localhost:9081/patio/devolvercarro")
    private String requestAdress;

    public void ocuparVaga(VagaRequest vagaRequest){
        WebClient webClient = WebClient.create();
        webClient.method(HttpMethod.DELETE).uri(requestAdress)
                .body(BodyInserters.fromValue(vagaRequest))
                .retrieve()
                .toEntity(Void.class);
    }
}
