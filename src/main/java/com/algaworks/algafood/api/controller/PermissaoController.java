package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private CadastroPermissaoService cadastroPermissao;

    @GetMapping
    public List<Permissao> listar() {
        return permissaoRepository.findAll();
    }

    @GetMapping("/{permissaoId}")
    public ResponseEntity<Permissao> buscar(@PathVariable Long permissaoId) {
        Optional<Permissao> permissao = permissaoRepository.findById(permissaoId);

        if (permissao.isPresent()) {
            return ResponseEntity.ok(permissao.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Permissao adicionar(@RequestBody Permissao permissao) {
        return cadastroPermissao.salvar(permissao);
    }

    @PutMapping("/{permissaoId}")
    public ResponseEntity<Permissao> atualizar(@PathVariable Long permissaoId,
                                             @RequestBody Permissao permissao) {
        Optional<Permissao> permissaoAtual = permissaoRepository.findById(permissaoId);

        if (permissaoAtual.isPresent()) {
            BeanUtils.copyProperties(permissao, permissaoAtual.get(), "id");

            Permissao permissaoSalva = cadastroPermissao.salvar(permissaoAtual.get());
            return ResponseEntity.ok(permissaoSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{permissaoId}")
    public ResponseEntity<?> remover(@PathVariable Long permissaoId) {
        try {
            cadastroPermissao.excluir(permissaoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}

