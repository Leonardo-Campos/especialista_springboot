package com.algaworks.algafood.api.mixin;

import com.algaworks.algafood.domain.model.Grupo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMixin {

    @JsonIgnore
    private List<Grupo> grupos = new ArrayList<>();
}
