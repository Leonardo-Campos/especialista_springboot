package com.algaworks.algafood.domain.exception;

public class EstadoNãoEncontradoException extends EntidadeNãoEncontradaException {

    private static final long serialVersionUID = 1L;

    public EstadoNãoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EstadoNãoEncontradoException(Long estadoId) {
        this(String.format("Não existe um cadastro de estado com código %d", estadoId));
    }
}
