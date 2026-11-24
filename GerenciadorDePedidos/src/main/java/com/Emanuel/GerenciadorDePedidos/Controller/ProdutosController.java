package com.Emanuel.GerenciadorDePedidos.Controller;

import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.DadosDetalhamentoProdutoDTO;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import com.Emanuel.GerenciadorDePedidos.Infra.Exceptions.TratadorDeErros.DadosErroValidacao;
import com.Emanuel.GerenciadorDePedidos.Service.ProdutosServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Produtos", description = "Cadastro e consulta do catálogo de produtos")
@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    private final ProdutosServices service;

    public ProdutosController(ProdutosServices service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista todos os produtos",
            description = "Retorna todos os produtos cadastrados. Se não houver nenhum, retorna uma lista vazia com status 200."
    )
    @ApiResponse(responseCode = "200", description = "Lista de produtos (pode ser vazia)")

    @GetMapping
    public ResponseEntity<List<Produtos>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Busca um produto pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content)
    })

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarPorId(
            @Parameter(description = "ID do produto", example = "1", required = true)
            @PathVariable Long id) {

        return service.buscaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Cadastra um novo produto",
            description = "Cria o produto e devolve seus dados. O header Location aponta para GET /api/produtos/{id}."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado",
                    headers = @Header(name = "Location", description = "URI do produto criado",
                            schema = @Schema(type = "string", example = "http://localhost:8081/api/produtos/1"))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DadosErroValidacao.class))))
    })
    @PostMapping("/cadastro")
    public ResponseEntity<DadosDetalhamentoProdutoDTO> cadastro(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do produto a ser cadastrado. O campo id é gerado pelo banco e não deve ser enviado.",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProdutosDTO.class),
                            examples = @ExampleObject(name = "Produto de bebida", value = """
                                    {
                                      "sku": "BEB-0001",
                                      "nomeProduto": "Água Mineral 500ml",
                                      "precoProduto": 2.50,
                                      "descricaoProduto": "Água mineral sem gás",
                                      "ativo": true,
                                      "categoria": "BEBIDAS"
                                    }
                                    """)))
            @Valid @RequestBody ProdutosDTO dados,
            UriComponentsBuilder uriBuilder) {

        Produtos produto = service.cadastraProduto(dados);
        var uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProdutoDTO(produto));
    }
}
