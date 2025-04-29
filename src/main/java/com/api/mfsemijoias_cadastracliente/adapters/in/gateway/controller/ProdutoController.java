package com.api.mfsemijoias_cadastracliente.adapters.in.gateway.controller;


import com.api.mfsemijoias_cadastracliente.adapters.in.request.ProdutoRequest;
import com.api.mfsemijoias_cadastracliente.adapters.in.response.ProdutoResponse;
import com.api.mfsemijoias_cadastracliente.domain.model.Produto;
import com.api.mfsemijoias_cadastracliente.ports.in.produto.ProdutoRequestMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.produto.ProdutoResponseMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.produto.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoResponseMapper produtoResponseMapper;
    private final ProdutoRequestMapper produtoRequestMapper;
    private final ProdutoRequest produtoRequest;

    public ProdutoController(ProdutoService produtoService, ProdutoResponseMapper produtoResponseMapper, ProdutoRequestMapper produtoRequestMapper, ProdutoRequest produtoRequest) {
        this.produtoService = produtoService;
        this.produtoResponseMapper = produtoResponseMapper;
        this.produtoRequestMapper = produtoRequestMapper;
        this.produtoRequest = produtoRequest;
    }


    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        Produto produto = produtoRequestMapper.toDomain(produtoRequest);
        produtoService.cadastrarProduto(produto);
        ProdutoResponse response = produtoResponseMapper.toResponse(produto);
        return ResponseEntity.status(201).body(response);
    }


}
