package com.api.mfsemijoias_cadastracliente.domain.validation;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IsProdutoValido {

    public boolean isValidNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");
        }
        if (nome.length() < 3 || nome.length() > 100) {
            throw new IllegalArgumentException("Nome do produto deve ter entre 3 e 100 caracteres");
        }
        return true;
    }

    public boolean isValidDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto não pode ser nula ou vazia");
        }
        if (descricao.length() < 10 || descricao.length() > 256) {
            throw new IllegalArgumentException("Descrição do produto deve ter entre 10 e 256 caracteres");
        }
        return true;
    }

    public boolean isValidValor(Double valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor do produto não pode ser nulo");
        }
        if (valor.compareTo(Double.valueOf(String.valueOf(BigDecimal.ZERO))) <= 0) {
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero");
        }
        return true;
    }

    public boolean isValidQuantidade(Integer quantidade) {
        if (quantidade == null) {
            throw new IllegalArgumentException("Quantidade do produto não pode ser nula");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade do produto não pode ser negativa");
        }
        return true;
    }

    public boolean isValidImagem(String imagem) {
        if (imagem == null || imagem.isEmpty()) {
            throw new IllegalArgumentException("Imagem do produto não pode ser nula ou vazia");
        }
        if (!imagem.startsWith("http://") && !imagem.startsWith("https://")) {
            throw new IllegalArgumentException("URL da imagem do produto deve ser válida");
        }
        return true;
    }
}
