package com.api.mfsemijoias_cadastracliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private String senha;
    private String usuario;
}