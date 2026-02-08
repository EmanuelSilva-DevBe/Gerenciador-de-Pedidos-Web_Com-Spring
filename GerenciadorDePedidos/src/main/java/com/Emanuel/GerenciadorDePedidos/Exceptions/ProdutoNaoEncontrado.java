package com.Emanuel.GerenciadorDePedidos.Exceptions;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
