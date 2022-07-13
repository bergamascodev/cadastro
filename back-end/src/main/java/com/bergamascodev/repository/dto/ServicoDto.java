package com.bergamascodev.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"id"}, allowGetters = true, ignoreUnknown = true)
public class ServicoDto {

    private Long id;

    private String descricao;

    @NotNull
    private Long clienteId;

    private BigDecimal valor;
}