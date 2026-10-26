package com.Emanuel.GerenciadorDePedidos.Domains.Vendas;

import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Venda {
    private UUID idVenda;
    private List<Produtos> Idproduto;
    private BigDecimal valorTotalDavenda;

}
