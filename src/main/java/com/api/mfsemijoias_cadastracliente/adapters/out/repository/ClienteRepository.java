package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;

import java.util.UUID;

public interface ClienteRepository  {

    Cliente save(Cliente cliente);
    Cliente findById(UUID id);
    Cliente findByEmail(String email);
    Cliente findByCpf(String cpf);
    Cliente findByNome(String nome);
    Cliente deleteById(UUID id);
    Cliente update(Cliente cliente);

}
