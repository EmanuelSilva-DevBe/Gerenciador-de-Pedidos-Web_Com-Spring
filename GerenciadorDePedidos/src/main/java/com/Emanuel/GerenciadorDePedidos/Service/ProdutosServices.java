package com.Emanuel.GerenciadorDePedidos.Service;

import com.Emanuel.GerenciadorDePedidos.DTO.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Models.Produtos;
import com.Emanuel.GerenciadorDePedidos.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutosServices {

    @Autowired
    private ProdutosRepository repositorio;


    private List<ProdutosDTO> converteDTO(List<Produtos> produtos){
        return produtos.stream()
                .map(p -> new ProdutosDTO(p.getId(), p.getNomeProduto(), p.getPrecoProduto(), p.getQuantidadeProduto(),
                        p.getDescricaoProduto(), p.getQuantidadeVendida()))
                .collect(Collectors.toList());
    }

    public Produtos CadastraProduto(String nomeProduto, double precoProduto, String descricaoProduto){
        Produtos produto = new Produtos(nomeProduto, precoProduto, descricaoProduto);

        return repositorio.save(produto);
    }

    public List<ProdutosDTO> ListarProdutosMaisVendidos(){
        return converteDTO(repositorio.findTop5ByOrderByQuantidadeVendidaDesc());
    }

    public List<ProdutosDTO> excluirProduto(String nome) {
        if (nome == null || nome.isEmpty()) {
            return Collections.emptyList();
        }

        return repositorio.findByNomeProdutoContainingIgnoreCase(nome);
    }

}
