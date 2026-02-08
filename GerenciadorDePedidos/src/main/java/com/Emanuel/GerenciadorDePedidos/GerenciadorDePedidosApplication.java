package com.Emanuel.GerenciadorDePedidos;

import com.Emanuel.GerenciadorDePedidos.Models.Produtos;
import com.Emanuel.GerenciadorDePedidos.Repository.ProdutosRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GerenciadorDePedidosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDePedidosApplication.class, args);
	}
}
