package com.Emanuel.GerenciadorDePedidos.Infra.Exceptions;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
