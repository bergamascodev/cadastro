package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.dto.ServicoDto;
import com.bergamascodev.repository.entity.Cliente;
import com.bergamascodev.repository.entity.Servico;
import com.bergamascodev.repository.enums.MensagensErroEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServicoConverter implements Converter<Servico, ServicoDto> {

    @Inject
    ClienteConverter clienteConverter;

    @Override
    public ServicoDto toDto(Servico entity) {
        return ServicoDto.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .clienteId(entity.getCliente().getId())
                .valor(entity.getValor())
                .build();
    }

    @Override
    public Servico toEntity(ServicoDto dto) {
        return Servico.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .cliente(getCliente(dto))
                .valor(dto.getValor())
                .build();
    }

    @Override
    public List<ServicoDto> toDtoList(List<Servico> servicos) {
        List<ServicoDto> servicoDtos = new ArrayList<>();
        servicos.forEach(servico -> servicoDtos.add(toDto(servico)));
        return servicoDtos;
    }

    @Override
    public ServicoDto toDtoFromOptionalEntity(Optional<Servico> servico) {
        return servico.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<ServicoDto> toOptionalDtoFromOptionalEntity(Optional<Servico> servico) {
        return Optional.ofNullable(toDtoFromOptionalEntity(servico));
    }

    private Cliente getCliente(ServicoDto dto) {
        if(dto.getClienteId() == null) {
            throw new BergamascoException(MensagensErroEnum.CLIENTE_INVALIDO.getCodigo(), MensagensErroEnum.CLIENTE_INVALIDO.getMensagem());
        }
        return Cliente.builder().id(dto.getClienteId()).build();
    }
}
