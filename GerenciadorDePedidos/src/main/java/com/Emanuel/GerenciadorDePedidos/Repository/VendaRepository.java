package com.Emanuel.GerenciadorDePedidos.Repository;

import com.Emanuel.GerenciadorDePedidos.Domains.Vendas.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, UUID> {
}
