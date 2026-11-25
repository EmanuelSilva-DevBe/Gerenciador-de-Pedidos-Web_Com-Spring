package com.Emanuel.GerenciadorDePedidos.DTO;

import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.CategoriaDeProdutos;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;

import java.math.BigDecimal;

public record ListaProdutosDTO(
        Long idProduto,
        String nomeProduto,
        BigDecimal valorProduto,
        CategoriaDeProdutos categoria
) {
    public ListaProdutosDTO(Produtos produtos){
        this(produtos.getId(),produtos.getNomeProduto(),produtos.getPrecoProduto(),produtos.getCategoria());
    }

}
