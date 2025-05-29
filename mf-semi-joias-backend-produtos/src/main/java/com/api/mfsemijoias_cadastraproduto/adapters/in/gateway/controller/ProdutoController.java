package com.api.mfsemijoias_cadastraproduto.adapters.in.gateway.controller;

import com.api.mfsemijoias_cadastraproduto.adapters.in.request.ProdutoRequest;
import com.api.mfsemijoias_cadastraproduto.adapters.in.response.ProdutoResponse;
import com.api.mfsemijoias_cadastraproduto.domain.model.Produto;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoRequestMapper;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoResponseMapper;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoResponseMapper produtoResponseMapper;
    private final ProdutoRequestMapper produtoRequestMapper;

    public ProdutoController(ProdutoService produtoService, ProdutoResponseMapper produtoResponseMapper, ProdutoRequestMapper produtoRequestMapper) {
        this.produtoService = produtoService;
        this.produtoResponseMapper = produtoResponseMapper;
        this.produtoRequestMapper = produtoRequestMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        Produto produto = produtoRequestMapper.toDomain(produtoRequest);
        if (produto.getId() == null || produto.getId().isEmpty()) {
            produto.setId(UUID.randomUUID().toString());        }

        produtoService.cadastrarProduto(produto);
        ProdutoResponse response = produtoResponseMapper.toResponse(produto);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarProduto(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = produtoRequestMapper.toDomain(produtoRequest);
        produto.setId(id); // Certifique-se de que o modelo Produto possui o campo id
        produtoService.atualizarProduto(produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarTodosProdutos() {
        List<Produto> produtos = produtoService.listarTodosProdutos();
        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produtoResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(produtoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable String id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        ProdutoResponse produtoResponse = produtoResponseMapper.toResponse(produto);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosPorNome(@PathVariable String nome) {
        List<Produto> produtos = produtoService.buscarProdutosPorNome(nome);
        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produtoResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(produtoResponses);
    }

    @GetMapping("/preco/{preco}")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosPorPreco(@PathVariable double preco) {
        List<Produto> produtos = produtoService.buscarProdutosPorPreco(preco);
        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produtoResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(produtoResponses);
    }

    @GetMapping("/estoque/{quantidadeEstoque}")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosPorQuantidadeEstoque(@PathVariable int quantidadeEstoque) {
        List<Produto> produtos = produtoService.buscarProdutosPorQuantidadeEstoque(quantidadeEstoque);
        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produtoResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(produtoResponses);
    }
}
