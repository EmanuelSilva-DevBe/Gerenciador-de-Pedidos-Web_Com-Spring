package com.Emanuel.GerenciadorDePedidos.Domains.Catalogo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Table(name = "Produtos")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private String sku;
    @NotNull
    private BigDecimal precoProduto;

    @ColumnDefault("'Produto sem descricao'")
    private String descricaoProduto;
    @ColumnDefault("true")
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private CategoriaDeProdutos categoria;


    public Produtos(String nomeProduto, BigDecimal precoProduto, String descricaoProduto, CategoriaDeProdutos categoria, Boolean ativo) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoria = categoria;
        this.ativo = ativo;
    }
}
