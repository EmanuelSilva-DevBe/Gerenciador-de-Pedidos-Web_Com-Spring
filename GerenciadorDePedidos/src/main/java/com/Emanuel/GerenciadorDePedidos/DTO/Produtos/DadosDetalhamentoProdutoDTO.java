package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;

import java.math.BigDecimal;

public record DadosDetalhamentoProdutoDTO(
        Long id,
        String nomeProduto,
        BigDecimal precoProduto,
        String descricaoProduto

) {
    public DadosDetalhamentoProdutoDTO (Produtos produtos){
        this(produtos.getId(), produtos.getNomeProduto(), produtos.getPrecoProduto(), produtos.getDescricaoProduto());
    }

}
