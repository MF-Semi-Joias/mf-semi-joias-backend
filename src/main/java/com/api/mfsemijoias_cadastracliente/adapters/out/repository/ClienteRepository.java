package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;

import java.util.UUID;

public interface ClienteRepository  {

    void save(ClienteEntity clienteEntity);
    void findById(UUID id);
    void findByEmail(String email);
    void findByCpf(String cpf);
    void findByNome(String nome);
    void deleteById(UUID id);
    void update(ClienteEntity clienteEntity);

}
