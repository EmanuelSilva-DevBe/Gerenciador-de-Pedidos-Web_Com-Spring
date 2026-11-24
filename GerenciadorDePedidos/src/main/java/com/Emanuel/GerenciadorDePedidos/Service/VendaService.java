package com.Emanuel.GerenciadorDePedidos.Service;

import com.Emanuel.GerenciadorDePedidos.DTO.Vendas.DadosVendaDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Vendas.Venda;
import com.Emanuel.GerenciadorDePedidos.Repository.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class VendaService {
    private VendaRepository repository;

    public VendaService(VendaRepository repository){
        this.repository = repository;
    }

    public void criaVenda(@RequestBody DadosVendaDTO venda){
        repository.save(new Venda(venda));

    }

}
