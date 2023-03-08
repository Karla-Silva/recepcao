package com.estacionamento.recepcao.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class VagasClient {
    @Value("http://localhost:9081/patio/consultarvagas")
    private String requestAdress;

    @Async
    public Mono<Boolean> consultarVagas(){
        WebClient webClient = WebClient.create();
        return webClient.get().uri(requestAdress).retrieve().bodyToMono(Boolean.class);
    }

}
