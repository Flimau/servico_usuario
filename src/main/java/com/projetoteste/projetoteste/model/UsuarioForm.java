package com.projetoteste.projetoteste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioForm {
    private String nome;
    private String cep;
    private String documento;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private String data_nascimento;
}
