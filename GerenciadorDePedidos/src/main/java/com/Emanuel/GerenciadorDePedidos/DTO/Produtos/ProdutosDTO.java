package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.CategoriaDeProdutos;

import java.math.BigDecimal;

public record ProdutosDTO(Long id, String sku, String nomeProduto, BigDecimal precoProduto, String descricaoProduto, Boolean ativo,
                          CategoriaDeProdutos categoria) {

}
