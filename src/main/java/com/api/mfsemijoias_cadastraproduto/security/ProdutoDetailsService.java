package com.api.mfsemijoias_cadastraproduto.security;

import com.api.mfsemijoias_cadastraproduto.domain.model.Produto;
import com.api.mfsemijoias_cadastraproduto.ports.in.produto.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoDetailsService.class);
    private final ProdutoService produtoService;

    public ProdutoDetailsService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Tentando carregar produto: {}", username);
        Produto produto = (Produto) produtoService.buscarProdutosPorNome(username);
        if (produto == null) {
            logger.warn("Produto não encontrado: {}", username);
            throw new UsernameNotFoundException("Produto não encontrado");
        }
        logger.info("Produto encontrado: {}", produto.getNome());
        return User.builder()
                .username(produto.getNome())
                .roles("PRODUCT")
                .build();
    }
}