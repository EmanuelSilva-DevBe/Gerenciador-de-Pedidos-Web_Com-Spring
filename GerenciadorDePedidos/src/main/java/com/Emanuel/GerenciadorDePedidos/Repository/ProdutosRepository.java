package com.Emanuel.GerenciadorDePedidos.Repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    List<ProdutosDTO> findByNomeProdutoContainingIgnoreCase(String nome);


    Page<Produtos> findAllByAtivoTrue(Pageable paginacao);
}
