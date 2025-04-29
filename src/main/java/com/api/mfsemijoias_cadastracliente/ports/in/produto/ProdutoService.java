package com.api.mfsemijoias_cadastracliente.ports.in.produto;

import com.api.mfsemijoias_cadastracliente.domain.model.Produto;

import java.util.List;

public interface ProdutoService {

    void cadastrarProduto(Produto produto);

    void atualizarProduto(Produto produto);

    void deletarProduto(String id);

    Produto buscarProdutoPorId(String id);

    List<Produto> listarTodosProdutos();

    List<Produto> buscarProdutosPorNome(String nome);

    List<Produto> buscarProdutosPorPreco(double preco);

    List<Produto> buscarProdutosPorQuantidadeEstoque(int quantidadeEstoque);
}
