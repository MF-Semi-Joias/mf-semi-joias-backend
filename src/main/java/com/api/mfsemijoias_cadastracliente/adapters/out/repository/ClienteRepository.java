package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

public interface ClienteRepository  {

    ClienteEntity save(ClienteEntity clienteEntity);

    ClienteEntity findById(Long id);

    ClienteEntity findByEmail(String email);

    ClienteEntity findByUsuario(String usuario);

    ClienteEntity findByCpf(String cpf);

    ClienteEntity findByNome(String nome);

    ClienteEntity deleteById(Long id);

    ClienteEntity update(ClienteEntity clienteEntity);

}
