package com.Emanuel.GerenciadorDePedidos.Controller;

import com.Emanuel.GerenciadorDePedidos.DTO.DadosAutenticacao;
import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAnyElement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    private AuthenticationManager manager;

    public UsuarioController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {

        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
