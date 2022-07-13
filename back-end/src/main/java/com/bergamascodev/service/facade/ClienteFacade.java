package com.bergamascodev.service.facade;

import com.bergamascodev.repository.dto.ChangeStatusDto;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.service.ClienteService;
import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClienteFacade {

    @Inject
    ClienteService clienteService;

    public ClienteDto buscarPorId(Long id) {
        return clienteService.buscarPorId(id);
    }

    @Transactional
    @TransactionConfiguration(timeout = 900)
    public ClienteDto criar(ClienteDto clienteDto) {
        return clienteService.criar(clienteDto);
    }

    @Transactional
    @TransactionConfiguration(timeout = 900)
    public ClienteDto alterar(Long id, ClienteDto clienteDto) {
        return clienteService.alterar(id, clienteDto);
    }

    @Transactional
    @TransactionConfiguration(timeout = 900)
    public ClienteDto atualizarStatus(Long id, ChangeStatusDto changeStatusDto) {
        return clienteService.atualizarStatus(id, changeStatusDto);
    }

}
