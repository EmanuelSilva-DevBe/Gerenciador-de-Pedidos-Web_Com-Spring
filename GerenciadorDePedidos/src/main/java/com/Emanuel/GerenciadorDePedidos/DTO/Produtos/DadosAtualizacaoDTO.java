package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoDTO(
        @NotNull
        Long idVenda,
        String nomeProduto,
        BigDecimal precoProduto,
        String descricao
) {
}
