package com.projetoteste.projetoteste.service;

import com.projetoteste.projetoteste.entities.Usuario;
import com.projetoteste.projetoteste.model.UsuarioForm;

import java.text.ParseException;
import java.util.List;

public interface UsuarioService {
    Usuario insere (UsuarioForm usuarioForm) throws ParseException;
    void deleta (Integer id);
    Usuario update (UsuarioForm usuarioForm) throws ParseException;
    Usuario buscaUsuarioDocumento(String documento);
    List<Usuario> buscaTodosUsuarios();
}
