package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;

public interface ClienteRepository  {

    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    Cliente findByEmail(String email);
    Cliente findByCpf(String cpf);
    Cliente findByNome(String nome);
    Cliente deleteById(Long id);
    Cliente update(Cliente cliente);

}
