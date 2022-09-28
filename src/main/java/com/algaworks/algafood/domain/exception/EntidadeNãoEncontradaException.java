package com.algaworks.algafood.domain.exception;

public class EntidadeNãoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNãoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
