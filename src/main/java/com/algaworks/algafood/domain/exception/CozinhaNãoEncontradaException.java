package com.algaworks.algafood.domain.exception;

public class CozinhaNãoEncontradaException extends EntidadeNãoEncontradaException {

    private static final long serialVersionUID = 1L;

    public CozinhaNãoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CozinhaNãoEncontradaException(Long cidadeId) {
        this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
    }
}
