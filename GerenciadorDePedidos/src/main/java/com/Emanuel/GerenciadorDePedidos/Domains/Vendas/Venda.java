package com.Emanuel.GerenciadorDePedidos.Domains.Vendas;

import com.Emanuel.GerenciadorDePedidos.DTO.Vendas.DadosVendaDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Venda")
public class Venda {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idVenda;

    @OneToMany(mappedBy = "idVenda")
    private List<VendaItem> itens = new ArrayList<>();

    private BigDecimal valorTotalDavenda = BigDecimal.ZERO;


    public void adicionaItem(VendaItem item){
        item.setIdVenda(this);
        this.itens.add(item);
    }

    public void calculaValoTotal(){

        for (VendaItem item : itens){
           var valor = valorTotalDavenda.add(item.getPrecoUnitario());
        }

    }

    public Venda(DadosVendaDTO dados){
        this.itens = dados.itens();
        this.valorTotalDavenda = dados.valorTotal();
    }
}
