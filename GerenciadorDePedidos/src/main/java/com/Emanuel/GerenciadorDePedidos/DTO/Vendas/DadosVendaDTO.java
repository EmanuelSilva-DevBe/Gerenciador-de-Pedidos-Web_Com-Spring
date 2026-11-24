package com.Emanuel.GerenciadorDePedidos.DTO.Vendas;

import com.Emanuel.GerenciadorDePedidos.Domains.Vendas.Venda;
import com.Emanuel.GerenciadorDePedidos.Domains.Vendas.VendaItem;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record DadosVendaDTO(
        @NotEmpty
        List<VendaItem> itens,

        @Positive
        @Min(1)
        BigDecimal valorTotal
) {
        public DadosVendaDTO(Venda venda){
                this(venda.getItens(), venda.getValorTotalDavenda());
        }
}
