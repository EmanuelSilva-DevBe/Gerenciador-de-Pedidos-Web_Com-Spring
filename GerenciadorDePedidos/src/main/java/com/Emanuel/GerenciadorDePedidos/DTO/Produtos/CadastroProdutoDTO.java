package com.Emanuel.GerenciadorDePedidos.DTO.Produtos;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.CategoriaDeProdutos;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

public record CadastroProdutoDTO(@NotBlank String nomeProduto,
                                 @NotNull @Positive BigDecimal precoProduto,
                                 @ColumnDefault("'Produto sem descricao'")
                                 String decricaoProduto,
                                 @ColumnDefault("true")
                                 Boolean ativo,
                                 CategoriaDeProdutos categoria) {
    public CadastroProdutoDTO(Produtos p){
        this(p.getNomeProduto(), p.getPrecoProduto(), p.getDescricaoProduto(), p.getAtivo(), p.getCategoria());

    }
}
