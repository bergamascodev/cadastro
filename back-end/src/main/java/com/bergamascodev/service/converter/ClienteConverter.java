package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.entity.Cliente;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteConverter implements Converter<Cliente, ClienteDto> {

    @Override
    public ClienteDto toDto(Cliente entity) {
        return ClienteDto.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getNome())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Cliente toEntity(ClienteDto dto) {
        return Cliente.builder()
                .id(dto.getId())
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .status(dto.getStatus())
                .build();
    }

    @Override
    public List<ClienteDto> toDtoList(List<Cliente> clientes) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        clientes.forEach(cliente -> clienteDtos.add(toDto(cliente)));
        return clienteDtos;
    }

    @Override
    public ClienteDto toDtoFromOptionalEntity(Optional<Cliente> cliente) {
        return cliente.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<ClienteDto> toOptionalDtoFromOptionalEntity(Optional<Cliente> cliente) {
        return Optional.ofNullable(toDtoFromOptionalEntity(cliente));
    }

}
