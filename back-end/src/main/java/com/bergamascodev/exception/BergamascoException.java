package com.bergamascodev.exception;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BergamascoException extends RuntimeException {

    protected Integer codigoErro;

    protected Integer responseStatus;

    protected BergamascoException(Throwable source) { super(source); }

    protected BergamascoException(Throwable source, String message) { super(message, source); }

    public BergamascoException(String mensagemErro) {
        super(mensagemErro);
        this.codigoErro = 0;
    }

    public BergamascoException(Integer codigoErro, String mensagemErro) {
        super(mensagemErro);
        this.codigoErro = codigoErro;
    }

    public BergamascoException(String mensagemErro, ResponseEnum responseStatus) {
        super(mensagemErro);
        this.codigoErro = 0;
        this.responseStatus = responseStatus.getStatus();
    }

    public BergamascoException(Integer codigoErro, String mensagemErro, ResponseEnum responseStatus) {
        super(mensagemErro);
        this.codigoErro = codigoErro;
        this.responseStatus = responseStatus.getStatus();
    }

    public BergamascoException(Integer codigoErro, String mensagemErro, Integer responseStatus) {
        super(mensagemErro);
        this.codigoErro = codigoErro;
        this.responseStatus = responseStatus;
    }

    public String getMensagemErro() { return getMessage(); }
}
