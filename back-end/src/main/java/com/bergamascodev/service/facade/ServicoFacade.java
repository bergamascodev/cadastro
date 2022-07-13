package com.bergamascodev.service.facade;

import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.dto.ServicoDto;
import com.bergamascodev.service.ServicoService;
import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ServicoFacade {

    @Inject
    ServicoService servicoService;

    public ServicoDto buscarPorId(Long id) {
        return servicoService.buscarPorId(id);
    }

    @Transactional
    @TransactionConfiguration(timeout = 900)
    public ServicoDto criar(ServicoDto servicoDto) {
        return servicoService.criar(servicoDto);
    }

    @Transactional
    @TransactionConfiguration(timeout = 900)
    public ServicoDto alterar(Long id, ServicoDto servicoDto) {
        return servicoService.alterar(id, servicoDto);
    }

}
