package com.api.mfsemijoias_cadastraproduto.adapters.out.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.api.mfsemijoias_cadastraproduto.adapters.out.entity.ProdutoEntity;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoMapper;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpli implements ProdutoRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final ProdutoMapper produtoMapper;


    public ProdutoRepositoryImpli(DynamoDBMapper dynamoDBMapper, ProdutoMapper produtoMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.produtoMapper = produtoMapper;
    }


    @Override
    public void save(ProdutoEntity produtoEntity) {
        dynamoDBMapper.save(produtoEntity);
    }

    @Override
    public ProdutoEntity findById(String id) {
        ProdutoEntity produtoEntity = dynamoDBMapper.load(ProdutoEntity.class, id);

        return produtoEntity;
    }

    @Override
    public void update(ProdutoEntity produtoEntity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<ProdutoEntity> findAll() {
        return List.of();
    }

    @Override
    public List<ProdutoEntity> findByNome(String nome) {
        return List.of();
    }

    @Override
    public List<ProdutoEntity> findByPreco(double preco) {
        return List.of();
    }

    @Override
    public List<ProdutoEntity> findByQuantidadeEstoque(int quantidadeEstoque) {
        return List.of();
    }
}
