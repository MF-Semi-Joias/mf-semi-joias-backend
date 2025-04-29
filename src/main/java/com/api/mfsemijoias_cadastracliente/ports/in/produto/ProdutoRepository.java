package com.api.mfsemijoias_cadastracliente.ports.in.produto;

import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ProdutoEntity;
import com.api.mfsemijoias_cadastracliente.domain.model.Produto;

import java.util.List;

public interface ProdutoRepository {

    void save(ProdutoEntity produtoEntity);

    ProdutoEntity findById(String id);

    void update(ProdutoEntity produtoEntity);

    void delete(String id);

    List<ProdutoEntity> findAll();

    List<ProdutoEntity> findByNome(String nome);


    List<ProdutoEntity> findByPreco(double preco);

    List<ProdutoEntity> findByQuantidadeEstoque(int quantidadeEstoque);
}
