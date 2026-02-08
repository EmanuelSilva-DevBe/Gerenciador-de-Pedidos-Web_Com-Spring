package com.Emanuel.GerenciadorDePedidos.Controller;

import com.Emanuel.GerenciadorDePedidos.DTO.ProdutosDTO;
import com.Emanuel.GerenciadorDePedidos.Exceptions.ProdutoNaoEncontrado;
import com.Emanuel.GerenciadorDePedidos.Models.Produtos;
import com.Emanuel.GerenciadorDePedidos.Repository.ProdutosRepository;
import com.Emanuel.GerenciadorDePedidos.Service.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosServices service;

    @Autowired
    private ProdutosRepository repositorio;



    @GetMapping
    public String listar(Model model){
        List<Produtos> produtosCadastrados = repositorio.findAll();

        model.addAttribute("produtos", produtosCadastrados);
        return "produtos";
    }

    @GetMapping("/novo")
    public String formulario(){
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String nomeProduto, @RequestParam Double precoProduto,
                         @RequestParam String descricaoProduto){

        service.CadastraProduto(nomeProduto, precoProduto, descricaoProduto);


        return "redirect:/produtos"; //Redireciona para a lista de produtos
    }

    @GetMapping("/excluir")
    public String excluir() {
       return "excluir";
    }

    @GetMapping("/excluir/confirmar-exclusao")
    public String confirmarExclusao(){
        return "confirmar-exclusao";
    }

   



}
