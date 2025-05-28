package com.api.mfsemijoias_cadastraproduto.ports.in.produto;

import com.api.mfsemijoias_cadastraproduto.adapters.out.entity.ProdutoEntity;
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
