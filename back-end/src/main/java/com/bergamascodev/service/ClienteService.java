package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.repository.dto.ChangeStatusDto;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.entity.Cliente;
import com.bergamascodev.repository.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.ClienteRepository;
import com.bergamascodev.service.converter.ClienteConverter;
import com.bergamascodev.service.validator.ClienteValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    ClienteConverter converter;

    @Inject
    ClienteValidator clienteValidator;

    public ClienteDto criar(ClienteDto clienteDto) {
        clienteValidator.validarCliente(clienteDto);
        try {
            Cliente cliente = converter.toEntity(clienteDto);
            clienteRepository.persistAndFlush(cliente);
            return converter.toDto(cliente);
        } catch (Exception exception) {
            throw gerarClienteException(MensagensErroEnum.FALHA_SALVAR);
        }
    }

    public ClienteDto alterar(Long id, ClienteDto clienteDto){
        clienteValidator.validarCliente(id, clienteDto);
        Cliente cliente = recuperarCliente(id);
        try {
            atribuirValoresCliente(cliente, converter.toEntity(clienteDto));
            clienteRepository.persistAndFlush(cliente);
            return converter.toDto(cliente);
        } catch (Exception exception) {
            throw gerarClienteException(MensagensErroEnum.FALHA_SALVAR);
        }
    }

    public ClienteDto buscarPorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findByIdOptional(id);
        if(clienteOptional.isEmpty()){
            throw gerarClienteExcpetion(MensagensErroEnum.CLIENTE_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return converter.toDtoFromOptionalEntity(clienteOptional);
    }

    public ClienteDto atualizarStatus(Long id, ChangeStatusDto changeStatusDto){
        Optional<Cliente> clienteOptional = clienteRepository.findByIdOptional(id);
        if(id == null || clienteOptional.isEmpty()) {
            throw gerarClienteExcpetion(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        if(changeStatusDto.getStatus() == null) {
            throw gerarClienteExcpetion(MensagensErroEnum.STATUS_INVALIDO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        try {
            Cliente cliente = clienteOptional.get();
            cliente.setStatus(changeStatusDto.getStatus());
            clienteRepository.persistAndFlush(cliente);
            return converter.toDto(cliente);
        } catch (Exception exception) {
            throw gerarClienteException(MensagensErroEnum.FALHA_SALVAR);
        }
    }

    private Cliente recuperarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null) {
            throw gerarClienteExcpetion(MensagensErroEnum.CLIENTE_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return cliente;
    }

    private Cliente atribuirValoresCliente(Cliente clienteOriginal, Cliente clienteAlterado) {
        clienteOriginal.setNome(clienteAlterado.getNome());
        clienteOriginal.setCpf(clienteAlterado.getCpf());
        return clienteOriginal;
    }

    private BergamascoException gerarClienteException(MensagensErroEnum mensagensErroEnum) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem());
    }

    private BergamascoException gerarClienteExcpetion(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
