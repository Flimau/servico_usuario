package com.projetoteste.projetoteste.repository;

import com.projetoteste.projetoteste.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByDocumento(String documento);
}
