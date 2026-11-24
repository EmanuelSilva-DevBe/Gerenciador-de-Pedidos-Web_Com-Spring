package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.CategoriaDeProdutos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = "Dados de um produto do catálogo")
public record ProdutosDTO(
        @Schema(description = "Identificador gerado pelo banco", example = "1",
                accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "Código SKU do produto", example = "BEB-0001")
        String sku,

        @Schema(description = "Nome do produto", example = "Água Mineral 500ml")
        @NotBlank
        String nomeProduto,

        @Schema(description = "Preço unitário em reais", example = "2.50")
        @NotNull @Positive
        BigDecimal precoProduto,

        @Schema(description = "Descrição livre do produto", example = "Água mineral sem gás")
        String descricaoProduto,

        @Schema(description = "Indica se o produto está disponível para venda", example = "true")
        Boolean ativo,

        // Documentação vem do próprio enum CategoriaDeProdutos (fonte única da verdade)
        CategoriaDeProdutos categoria) {
}
