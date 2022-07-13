package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.ClienteRepository;
import com.bergamascodev.service.converter.ClienteConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ClienteValidator {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    ClienteConverter converter;

    public void validarCliente(ClienteDto clienteDto) {
        validarCliente(null, clienteDto);
    }

    public void validarCliente(Long id, ClienteDto clienteDto) {
        validarId(clienteDto);
//        validarCpf(clienteDto);
    }

    public void validarId(ClienteDto clienteDto) {
        if(clienteDto.getId() != null) {
            throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

 //   public void validarCpf(ClienteDto clienteDto) {
 //       if(clienteDto.getCpf() == null){
 //           throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
 //       }
 //   }

    private BergamascoException gerarClienteException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

}
