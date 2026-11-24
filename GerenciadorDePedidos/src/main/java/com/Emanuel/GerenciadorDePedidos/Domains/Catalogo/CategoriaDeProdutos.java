package com.Emanuel.GerenciadorDePedidos.Domains.Catalogo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Categoria do produto. Valores aceitos: ACOUGUE, MERCEARIA, BEBIDAS, FITNESS.",
        example = "BEBIDAS",
        enumAsRef = true
)
public enum CategoriaDeProdutos {
    ACOUGUE,
    MERCEARIA,
    BEBIDAS,
    FITNESS
}
