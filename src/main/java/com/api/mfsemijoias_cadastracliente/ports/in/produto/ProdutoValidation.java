package com.api.mfsemijoias_cadastracliente.ports.in.produto;

import com.api.mfsemijoias_cadastracliente.domain.model.Produto;

public interface ProdutoValidation {

    boolean produtoValido(Produto produto);

    boolean isExistProduto(Produto produto);

    boolean isExistIdProduto(Produto produto);

    boolean isExistNomeProduto(Produto produto);

    boolean isExistDescricaoProduto(Produto produto);

    boolean isExistValorProduto(Produto produto);

    boolean isExistQuantidadeProduto(Produto produto);

    boolean isExistImagemProduto(Produto produto);

}
