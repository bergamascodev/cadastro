package com.bergamascodev.repository.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagensErroEnum {

    FALHA_SALVAR(1, "Falha ao salvar cliente"),
    REQUISICAO_INVALIDA(2, "Dados inválidos"),
    CLIENTE_NAO_ENCONTRADO(3, "Cliente não encontrado"),
    STATUS_INVALIDO(4, "Status informado inválido"),
    CLIENTE_INVALIDO(5, "Cliente inválido"),
    SERVICO_NAO_ENCONTRADO(6, "Serviço não encontrado");

    private Integer codigo;
    private String mensagem;
}
