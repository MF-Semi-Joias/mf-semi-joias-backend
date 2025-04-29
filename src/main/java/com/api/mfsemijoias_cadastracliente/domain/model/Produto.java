package com.api.mfsemijoias_cadastracliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String id;
    private String nome;
    private String descricao;
    private String categoria;
    private String preco;
    private String imagemUrl;
    private String quantidadeEstoque;
    private String dataCadastro;
    private String dataAtualizacao;

}
