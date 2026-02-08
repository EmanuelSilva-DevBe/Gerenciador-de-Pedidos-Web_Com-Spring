package com.Emanuel.GerenciadorDePedidos.DTO;

public record ProdutosDTO(Long id, String nomeProduto, Double precoProduto, Integer quantidadeProduto,
                          String descricaoProduto, Integer quantidadeVendida) {
}
