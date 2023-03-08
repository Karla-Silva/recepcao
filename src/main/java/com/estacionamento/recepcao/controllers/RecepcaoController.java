package com.estacionamento.recepcao.controllers;

import com.estacionamento.recepcao.payloads.request.CadastrarMensalistaRequest;
import com.estacionamento.recepcao.payloads.request.ReceberClienteRequest;
import com.estacionamento.recepcao.payloads.request.SaidaRequest;
import com.estacionamento.recepcao.services.CadastrarMensalistaService;
import com.estacionamento.recepcao.services.ReceberClienteService;
import com.estacionamento.recepcao.services.RegistrarSaidaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recepcao")
@RequiredArgsConstructor
@Slf4j
public class RecepcaoController {
    private final CadastrarMensalistaService cadastrarMensalistaService;
    private final ReceberClienteService receberClienteService;
    private final RegistrarSaidaService registrarSaidaService;
    @PostMapping("/recebercliente")
    @ResponseStatus(HttpStatus.CREATED)
    public void recebercliente(@RequestBody ReceberClienteRequest receberClienteRequest){
        String retorno = receberClienteService.execute(receberClienteRequest);
        log.info(retorno);
    }
    @PostMapping("/cadastrarmensalista")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarmensalista(@RequestBody CadastrarMensalistaRequest cadastrarMensalistaRequest){
        String retorno = cadastrarMensalistaService.execute(cadastrarMensalistaRequest);
        log.info(retorno);
    }
    @DeleteMapping("/registrarsaida")
    @ResponseStatus(HttpStatus.OK)
    public void registrarSaida(SaidaRequest saidaRequest){
        String retorno = registrarSaidaService.execute(saidaRequest);
        log.info(retorno);
    }
}
