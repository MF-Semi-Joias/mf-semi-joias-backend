package com.api.mfsemijoias_cadastracliente.security;

import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteRepository;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class ClienteDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByUser( usuario);
        return new User(cliente.getNome(), cliente.getSenha(), new ArrayList<>());
    }
}