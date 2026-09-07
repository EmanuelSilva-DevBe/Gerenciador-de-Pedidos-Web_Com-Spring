package com.Emanuel.GerenciadorDePedidos.Service;

import com.Emanuel.GerenciadorDePedidos.DTO.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.CategoriaDeProdutos;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import com.Emanuel.GerenciadorDePedidos.Repository.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProdutosServices {

    @Autowired
    private ProdutosRepository repositorio;


    private List<ProdutosDTO> converteDTO(List<Produtos> produtos) {
        return produtos.stream()
                .map(p -> new ProdutosDTO(p.getId(), p.getSku(), p.getNomeProduto(), p.getPrecoProduto(), p.getDescricaoProduto(),
                p.getAtivo(), p.getCategoria()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> cadastraProduto(String nomeProduto, BigDecimal precoProduto, String descricaoProduto, CategoriaDeProdutos categoria, Boolean ativo) {
        Produtos produto = new Produtos(nomeProduto, precoProduto, descricaoProduto, categoria, ativo);
        repositorio.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso");
    }
    public List<ProdutosDTO> excluirProduto(String nome) {
        if (nome == null || nome.isEmpty()) {
            return Collections.emptyList();
        }

        return repositorio.findByNomeProdutoContainingIgnoreCase(nome);
    }

    public List<Produtos> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<Produtos> buscaPorId(Long id) {
        return repositorio.findById(id);
    }



}
