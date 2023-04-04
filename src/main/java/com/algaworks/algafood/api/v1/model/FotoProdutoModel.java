package com.algaworks.algafood.api.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class FotoProdutoModel extends RepresentationModel<FotoProdutoModel> {

    private String nomeArquivo;

    private String descricao;

    private String contentType;

    private Long tamanho;

}
