package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.api.mixin.*;
import com.algaworks.algafood.domain.model.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {


    private static final long serialVersionUID = 1L;

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
        setMixInAnnotation(Grupo.class, GrupoMixin.class);
        setMixInAnnotation(Usuario.class, UsuarioMixin.class);
    }
}
