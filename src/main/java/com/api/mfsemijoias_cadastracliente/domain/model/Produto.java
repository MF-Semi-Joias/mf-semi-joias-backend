package com.api.mfsemijoias_cadastracliente.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Produto {

    private String id ;
    private String nome;
    private String descricao;
    private String categoria;
    private String preco;
    private String imagemUrl;
    private String quantidadeEstoque;
    private String dataCadastro;
    private String dataAtualizacao;

    public Produto(String id, String nome, String descricao, String categoria, String preco, String imagemUrl, String quantidadeEstoque, String dataCadastro, String dataAtualizacao) {
        this.id  = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }



}
