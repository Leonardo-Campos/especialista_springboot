package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)// reason = "Entidade Não encontrada")
public class EntidadeNãoEncontradaException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadeNãoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
