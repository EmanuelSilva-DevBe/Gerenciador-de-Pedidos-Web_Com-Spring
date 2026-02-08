package com.Emanuel.GerenciadorDePedidos.Repository;

import com.Emanuel.GerenciadorDePedidos.DTO.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    List<Produtos> findTop5ByOrderByQuantidadeVendidaDesc();

    List<ProdutosDTO> findByNomeProdutoContainingIgnoreCase(String nome);
}
