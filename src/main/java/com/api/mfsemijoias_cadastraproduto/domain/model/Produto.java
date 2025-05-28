package com.api.mfsemijoias_cadastraproduto.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Produto {

    private String id ;
    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;
    private String imagemUrl;
    private Integer quantidadeEstoque;
    private String dataCadastro;
    private String dataAtualizacao;

    public Produto(String id, String nome, String descricao, String categoria, Double preco, String imagemUrl, Integer quantidadeEstoque, String dataCadastro, String dataAtualizacao) {
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
