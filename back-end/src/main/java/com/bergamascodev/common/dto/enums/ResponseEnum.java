package com.bergamascodev.common.dto.enums;

import org.apache.http.HttpStatus;

public enum ResponseEnum {
    OK(HttpStatus.SC_OK),
    CRIADO(HttpStatus.SC_CREATED),
    REQUISICAO_INVALIDA(HttpStatus.SC_BAD_REQUEST),
    NAO_AUTORIZADO(HttpStatus.SC_UNAUTHORIZED),
    ERRO_INTERNO(HttpStatus.SC_INTERNAL_SERVER_ERROR),
    NAO_ENCONTRADO(HttpStatus.SC_NOT_FOUND);

    private Integer status;

    ResponseEnum(Integer status) { this.status = status; }

    public Integer getStatus() { return status; }
}
