package com.projetoteste.projetoteste.controller;

import com.projetoteste.projetoteste.entities.Usuario;
import com.projetoteste.projetoteste.model.UsuarioForm;
import com.projetoteste.projetoteste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Usuario> insere(@RequestBody @Valid UsuarioForm usuarioForm) throws ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.insere(usuarioForm));
    }
    @GetMapping(path="/{documento}")
    public ResponseEntity<Usuario> listaUsuario(@PathVariable String documento){

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscaUsuarioDocumento(documento));
    }
}


