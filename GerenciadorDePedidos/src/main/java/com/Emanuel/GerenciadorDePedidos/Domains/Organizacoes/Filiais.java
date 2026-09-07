package com.Emanuel.GerenciadorDePedidos.Domains.Organizacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Filiais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Min(value = 1, message = "O número deve ser maior que zero")
    @Positive(message = "O número deve ser positivo")
    private int codFilial;
    private String cidade;
    private Boolean ativa;



}
