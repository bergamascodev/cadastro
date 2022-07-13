package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.ClienteRepository;
import com.bergamascodev.repository.ServicoRepository;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.dto.ServicoDto;
import com.bergamascodev.repository.enums.MensagensErroEnum;
import com.bergamascodev.service.converter.ClienteConverter;
import com.bergamascodev.service.converter.ServicoConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ServicoValidator {

    @Inject
    ServicoRepository servicoRepository;

    @Inject
    ServicoConverter converter;

    public void validarServico(ServicoDto servicoDto) {
        validarServico(null, servicoDto);
    }

    public void validarServico(Long id, ServicoDto servicoDto) {
        validarId(servicoDto);
    }

    public void validarId(ServicoDto servicoDto) {
        if(servicoDto.getId() != null) {
            throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarClienteException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

}
