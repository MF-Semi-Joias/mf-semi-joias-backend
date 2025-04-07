package com.api.mfsemijoias_cadastracliente.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private String senha;
    private String usuario;
}