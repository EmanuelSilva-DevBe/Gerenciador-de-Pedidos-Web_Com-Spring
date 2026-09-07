package com.Emanuel.GerenciadorDePedidos.Repository;

import com.Emanuel.GerenciadorDePedidos.DTO.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    List<ProdutosDTO> findByNomeProdutoContainingIgnoreCase(String nome);



}
