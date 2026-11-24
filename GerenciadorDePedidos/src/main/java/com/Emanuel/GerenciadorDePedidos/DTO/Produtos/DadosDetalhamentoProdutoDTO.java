package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resumo do produto devolvido após o cadastro")
public record DadosDetalhamentoProdutoDTO(
        @Schema(example = "1") Long id,
        @Schema(example = "Água Mineral 500ml") String nomeProduto,
        @Schema(example = "2.50") BigDecimal precoProduto,
        @Schema(example = "Água mineral sem gás") String descricaoProduto
) {
    public DadosDetalhamentoProdutoDTO(Produtos produtos) {
        this(produtos.getId(), produtos.getNomeProduto(), produtos.getPrecoProduto(), produtos.getDescricaoProduto());
    }
}
