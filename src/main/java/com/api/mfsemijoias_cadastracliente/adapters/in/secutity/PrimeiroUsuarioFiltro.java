package com.api.mfsemijoias_cadastracliente.adapters.in.secutity;

import com.api.mfsemijoias_cadastracliente.domain.service.ClienteServiceImpli;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class PrimeiroUsuarioFiltro extends OncePerRequestFilter {

    private final ClienteServiceImpli clienteService;

    public PrimeiroUsuarioFiltro(ClienteServiceImpli clienteService) {
        this.clienteService = clienteService;
    }

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
    boolean existeUsuario = clienteService.existeUsuarioCadastrado();
    request.setAttribute("primeiroUsuario", !existeUsuario);
    filterChain.doFilter(request, response);
}
}