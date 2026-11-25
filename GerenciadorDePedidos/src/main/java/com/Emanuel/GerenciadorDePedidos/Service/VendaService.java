package com.Emanuel.GerenciadorDePedidos.Service;

import com.Emanuel.GerenciadorDePedidos.DTO.Vendas.DadosVendaDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Vendas.Venda;
import com.Emanuel.GerenciadorDePedidos.Repository.VendaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class VendaService {
    private VendaRepository repository;

    public VendaService(VendaRepository repository){
        this.repository = repository;
    }

    public void criaVenda(@RequestBody DadosVendaDTO venda){
        repository.save(new Venda(venda));
    }
    public void apagaVenda(UUID idVenda){
        var venda = repository.getReferenceById(idVenda);

        venda.deletaVenda();
    }

    public Page<DadosVendaDTO> listaVendas(Pageable page){
         return repository.findAll(page)
                 .map(DadosVendaDTO::new);
    }

}
