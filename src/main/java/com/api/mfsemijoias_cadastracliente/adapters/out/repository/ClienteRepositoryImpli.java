package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpli implements ClienteRepository {
    @Override
    public ClienteEntity save(ClienteEntity clienteEntity) {
        return save(clienteEntity);
    }

    @Override
    public ClienteEntity findById(Long id) {
        return findById(id);
    }

    @Override
    public ClienteEntity findByEmail(String email) {
        return findByEmail(email);
    }

    @Override
    public ClienteEntity findByUsuario(String usuario) {
        return findByUsuario(usuario);
    }

    @Override
    public ClienteEntity findByCpf(String cpf) {
        return findByCpf(cpf);
    }

    @Override
    public ClienteEntity findByNome(String nome) {
        return findByNome(nome);
    }

    @Override
    public ClienteEntity deleteById(Long id) {
        return deleteById(id);
    }

    @Override
    public ClienteEntity update(ClienteEntity clienteEntity) {
        return update(clienteEntity);
    }
}
