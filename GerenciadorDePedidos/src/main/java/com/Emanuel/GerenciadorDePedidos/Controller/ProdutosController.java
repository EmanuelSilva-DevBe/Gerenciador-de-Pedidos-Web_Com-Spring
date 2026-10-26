package com.Emanuel.GerenciadorDePedidos.Controller;

import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.DadosDetalhamentoProdutoDTO;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import com.Emanuel.GerenciadorDePedidos.Service.ProdutosServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    private final ProdutosServices service;

    public ProdutosController(ProdutosServices service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listar() {
        var listaProdutos = service.listarTodos();

        return ResponseEntity.ok(listaProdutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produtos>> buscarPorId(@PathVariable Long id) {
        var produto = service.buscaPorId(id);

        return ResponseEntity.ok(produto);
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@Valid @RequestBody ProdutosDTO dados, UriComponentsBuilder uriBuilder){
        Produtos produto = new Produtos();
        service.cadastraProduto(dados);
        var uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(produto.getId()).toUri();


        return ResponseEntity.created(uri).body(new DadosDetalhamentoProdutoDTO(produto));
    }
}

