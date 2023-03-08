package com.estacionamento.recepcao.controllers;

import com.estacionamento.recepcao.payloads.request.CadastrarMensalistaRequest;
import com.estacionamento.recepcao.payloads.request.ReceberClienteRequest;
import com.estacionamento.recepcao.payloads.request.VagaRequest;
import com.estacionamento.recepcao.services.CadastrarMensalistaService;
import com.estacionamento.recepcao.services.ReceberClienteService;
import com.estacionamento.recepcao.services.RegistrarSaidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recepcao")
@RequiredArgsConstructor
public class RecepcaoController {
    private final CadastrarMensalistaService cadastrarMensalistaService;
    private final ReceberClienteService receberClienteService;
    private final RegistrarSaidaService registrarSaidaService;
    @PostMapping("/recebercliente")
    @ResponseStatus(HttpStatus.CREATED)
    public void recebercliente(@RequestBody ReceberClienteRequest receberClienteRequest){
        receberClienteService.execute(receberClienteRequest);
    }
    @PostMapping("/cadastrarmensalista")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarmensalista(@RequestBody CadastrarMensalistaRequest cadastrarMensalistaRequest){
        cadastrarMensalistaService.execute(cadastrarMensalistaRequest);
    }
    @DeleteMapping("/registrarsaida")
    @ResponseStatus(HttpStatus.OK)
    public void registrarSaida(VagaRequest vagaRequest){
        registrarSaidaService.execute(vagaRequest);
    }
}
