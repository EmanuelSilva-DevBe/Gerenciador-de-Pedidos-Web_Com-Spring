package com.Emanuel.GerenciadorDePedidos.Domains.Catalogo;

import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.DadosAtualizacaoDTO;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
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


    public Produtos(ProdutosDTO p) {
        this.nomeProduto = p.nomeProduto();
        this.precoProduto = p.precoProduto();
        this.descricaoProduto = p.descricaoProduto();
        this.categoria = p.categoria();
        this.ativo = p.ativo();
    }

    public void excluirProduto() {
        ativo = false;
    }

    public void atualizaDados(DadosAtualizacaoDTO dados){
        if (dados.nomeProduto()!=null){
            this.nomeProduto = dados.nomeProduto();
        }if (dados.precoProduto()!=null){
            this.precoProduto = dados.precoProduto();
        }if (dados.descricao()!=null) {
            this.descricaoProduto = dados.descricao();
        }
    }

}
