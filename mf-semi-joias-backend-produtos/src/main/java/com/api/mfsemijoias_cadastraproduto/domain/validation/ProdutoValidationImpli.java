package com.api.mfsemijoias_cadastraproduto.domain.validation;

import com.api.mfsemijoias_cadastraproduto.domain.model.Produto;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoValidation;

public class ProdutoValidationImpli implements ProdutoValidation {

    private final IsProdutoValido isProdutoValido;

    public ProdutoValidationImpli(IsProdutoValido isProdutoValido)
    {
        this.isProdutoValido = isProdutoValido;
    }

    public boolean produtoValido(Produto produto) {
        isProdutoValido.isValidNome(produto.getNome());
        isProdutoValido.isValidDescricao(produto.getDescricao());
        isProdutoValido.isValidValor(Double.valueOf(produto.getPreco()));
        isProdutoValido.isValidQuantidade(produto.getQuantidadeEstoque());
        isProdutoValido.isValidImagem(produto.getImagemUrl());
        return true;
    }

    @Override
    public boolean isExistProduto(Produto produto) {

        return false;
    }

    @Override
    public boolean isExistIdProduto(Produto produto) {
        return false;
    }

    @Override
    public boolean isExistNomeProduto(Produto produto) {
        return false;
    }

    @Override
    public boolean isExistDescricaoProduto(Produto produto) {
        return false;
    }

    @Override
    public boolean isExistValorProduto(Produto produto) {
        return false;
    }

    @Override
    public boolean isExistQuantidadeProduto(Produto produto) {
        return false;
    }

    @Override
    public boolean isExistImagemProduto(Produto produto) {
        return false;
    }
}
