package com.algaworks.algafood.domain.exception;

public class RestauranteNãoEncontradoException extends EntidadeNãoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RestauranteNãoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNãoEncontradoException(Long cidadeId) {
        this(String.format("Não existe um cadastro de restaurante com código %d", cidadeId));
    }
}
