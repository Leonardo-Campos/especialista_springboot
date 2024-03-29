package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("/dados-inválidos", "Dados inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-inválido", "Parametro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem imcompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),

    ACESSO_NEGADO("/acesso-negado", "Acesso negado"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");


    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.title = title;
        this.uri = "https://algafood.com.br" + path;
    }
}
