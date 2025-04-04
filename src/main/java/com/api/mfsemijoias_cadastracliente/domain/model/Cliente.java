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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @NotBlank(message = "ID não pode ser nulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;
    @Email(message = "Email inválido")
    private String email;
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Telefone inválido")
    private String telefone;
    @CPF(message = "CPF inválido")
    @NotBlank(message = "CPF não pode ser nulo")
    private String CPF;
    //senha com8 digitos permitindo letras e números e caracteres especiais
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Senha inválida")
    private String senha;
    //pelo meno 6 digitos e letras e numeros
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Usuário inválido")
    private String usuario;
}