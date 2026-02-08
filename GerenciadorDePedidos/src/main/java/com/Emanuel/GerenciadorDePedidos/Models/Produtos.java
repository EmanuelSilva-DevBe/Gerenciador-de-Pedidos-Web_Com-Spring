package com.Emanuel.GerenciadorDePedidos.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Table(name = "Produtos")
@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private double precoProduto;
    private int quantidadeProduto;

    @Enumerated(EnumType.STRING)
    private CategoriaDeProdutos categoria;

    @ColumnDefault("Produto sem descrição")
    private String descricaoProduto;

    private int quantidadeVendida;

    public Produtos(){}

    public Produtos(String nomeProduto, double precoProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
    }



    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Long getId() {
        return id;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto){
        this.precoProduto = precoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

}
