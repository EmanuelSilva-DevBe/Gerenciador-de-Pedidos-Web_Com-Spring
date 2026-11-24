package com.Emanuel.GerenciadorDePedidos.Domains.Vendas;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "venda_itens")
public class VendaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal precoUnitario;

    private int quantidade;

    @ManyToOne
    private Produtos idProdutos;

    @ManyToOne
    private Venda idVenda;
}
