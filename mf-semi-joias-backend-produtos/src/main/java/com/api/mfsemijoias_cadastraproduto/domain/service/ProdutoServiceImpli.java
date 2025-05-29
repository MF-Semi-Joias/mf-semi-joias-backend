package com.api.mfsemijoias_cadastraproduto.domain.service;

import com.api.mfsemijoias_cadastraproduto.adapters.out.entity.ProdutoEntity;
import com.api.mfsemijoias_cadastraproduto.domain.model.Produto;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoMapper;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoRepository;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProdutoServiceImpli implements ProdutoService {

    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;
    private ProdutoEntity produtoEntity;

    public ProdutoServiceImpli(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        produtoEntity = produtoMapper.toEntity(produto);
        produtoRepository.save(produtoEntity);


    }

    @Override
    public void atualizarProduto(Produto produto) {
        produtoEntity = produtoMapper.toEntity(produto);
        produtoRepository.update(produtoEntity);

    }

    @Override
    public void deletarProduto(String id) {

    }

    @Override
    public Produto buscarProdutoPorId(String id) {
        Optional<ProdutoEntity> produtoEntityOptional = Optional.ofNullable(produtoRepository.findById(id));
        return produtoEntityOptional.map(produtoMapper::toDomain).orElse(null);

    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return List.of();
    }

    @Override
    public List<Produto> buscarProdutosPorNome(String nome) {
        return List.of();
    }

    @Override
    public List<Produto> buscarProdutosPorPreco(double preco) {
        return List.of();
    }

    @Override
    public List<Produto> buscarProdutosPorQuantidadeEstoque(int quantidadeEstoque) {
        return List.of();
    }
}
