package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNãoEncontradaException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/formapagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @GetMapping
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll();
    }

    @GetMapping("/{formapagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formapagamentoId) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formapagamentoId);

        if (formaPagamento.isPresent()) {
            return ResponseEntity.ok(formaPagamento.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
        return cadastroFormaPagamento.salvar(formaPagamento);
    }

    @PutMapping("/{formapagamentoId}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formapagamentoId,
                                             @RequestBody FormaPagamento formaPagamento) {
        Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(formapagamentoId);

        if (formaPagamentoAtual.isPresent()) {
            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id");

            FormaPagamento formaPagamentoSalva = cadastroFormaPagamento.salvar(formaPagamentoAtual.get());
            return ResponseEntity.ok(formaPagamentoSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{formapagamentoId}")
    public ResponseEntity<?> remover(@PathVariable Long formapagamentoId) {
        try {
            cadastroFormaPagamento.excluir(formapagamentoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNãoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}

