package com.Emanuel.GerenciadorDePedidos.Service;

import com.Emanuel.GerenciadorDePedidos.DTO.ListaProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.DadosAtualizacaoDTO;
import com.Emanuel.GerenciadorDePedidos.DTO.Produtos.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Domains.Catalogo.Produtos;
import com.Emanuel.GerenciadorDePedidos.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProdutosServices {

    @Autowired
    private ProdutosRepository repositorio;


    private List<ProdutosDTO> converteDTO(List<Produtos> produtos) {
        return produtos.stream()
                .map(p -> new ProdutosDTO(p.getId(), p.getSku(), p.getNomeProduto(), p.getPrecoProduto(), p.getDescricaoProduto(),
                p.getAtivo(), p.getCategoria()))
                .collect(Collectors.toList());
    }

    public Produtos cadastraProduto(ProdutosDTO p) {
        Produtos produto = new Produtos(p);

        return repositorio.save(produto);
    }


    public void excluirProduto(Long idProduto) {
        var produtos = repositorio.getReferenceById(idProduto);

        produtos.excluirProduto();
    }

    public Page<ListaProdutosDTO> listarTodos(Pageable paginacao) {
        return repositorio.findAllByAtivoTrue(paginacao)
                .map(ListaProdutosDTO::new);
    }

    public Optional<Produtos> buscaPorId(Long id) {
        return repositorio.findById(id);
    }

    public void atualizaDadosProduto(DadosAtualizacaoDTO dados){
        var produto = repositorio.getReferenceById(dados.idVenda());

        produto.atualizaDados(dados);
    }



}
