package com.api.mfsemijoias_cadastracliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String usuario;
}