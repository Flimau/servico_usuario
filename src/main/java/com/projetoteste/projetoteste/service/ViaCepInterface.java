package com.projetoteste.projetoteste.service;

import com.projetoteste.projetoteste.model.ViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://viacep.com.br/ws",name = "viacepdto")
public interface ViaCepInterface {
    @RequestMapping(value = "/{cep}/json/", method = RequestMethod.GET)
    ViaCepDTO buscarEndereco(@PathVariable String cep);

}
