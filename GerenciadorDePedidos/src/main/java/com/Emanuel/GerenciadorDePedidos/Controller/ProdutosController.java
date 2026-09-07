package com.Emanuel.GerenciadorDePedidos.Controller;

import com.Emanuel.GerenciadorDePedidos.DTO.CadastroProdutoDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import com.Emanuel.GerenciadorDePedidos.Service.ProdutosServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Produtos> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produtos> buscarPorId(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@Valid @RequestBody CadastroProdutoDTO dados){
        return service.cadastraProduto(dados.nomeProduto(), dados.precoProduto(), dados.decricaoProduto(), dados.categoria(), dados.ativo());
    }
}

