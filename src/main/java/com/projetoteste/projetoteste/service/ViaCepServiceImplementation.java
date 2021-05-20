package com.projetoteste.projetoteste.service;

import com.projetoteste.projetoteste.model.ViaCepDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViaCepServiceImplementation {
    private ViaCepInterface viaCepInterface;

    public ViaCepDTO retornaEndereco(String cep){
        return viaCepInterface.buscarEndereco(cep);
    }
}
