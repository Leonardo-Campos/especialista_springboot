package com.algaworks.algafood.domain.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CidadeNãoEncontradaException extends EntidadeNãoEncontradaException {

    private static final long serialVersionUID = 1L;

    public CidadeNãoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CidadeNãoEncontradaException(Long cidadeId) {
        this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
    }
}
