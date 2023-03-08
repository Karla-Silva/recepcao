package com.estacionamento.recepcao.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class VagasMensalistasClient {
    @Value("http://localhost:9081/patio/consultarvagasmensalistas")
    private String requestAdress;

    @Async
    public Mono<Boolean> consultarVagasMensalistas(){
        WebClient webClient = WebClient.create();
        return webClient.get().uri(requestAdress).retrieve().bodyToMono(Boolean.class);
    }
}
