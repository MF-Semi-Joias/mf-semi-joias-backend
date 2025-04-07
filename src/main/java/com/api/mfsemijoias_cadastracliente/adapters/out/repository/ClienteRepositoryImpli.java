package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpli implements ClienteRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteMapper.toEntity(cliente);
        dynamoDBMapper.save(clienteEntity);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findById(Long id) {
        ClienteEntity clienteEntity = dynamoDBMapper.load(ClienteEntity.class, id);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findByEmail(String email) {
        ClienteEntity clienteEntity = dynamoDBMapper.load(ClienteEntity.class, email);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        ClienteEntity clienteEntity = dynamoDBMapper.load(ClienteEntity.class, cpf);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findByNome(String nome) {
        ClienteEntity clienteEntity = dynamoDBMapper.load(ClienteEntity.class, nome);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente deleteById(Long id) {
        ClienteEntity clienteEntity = dynamoDBMapper.load(ClienteEntity.class, id);
        if (clienteEntity != null) {
            dynamoDBMapper.delete(clienteEntity);
        }
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente update(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteMapper.toEntity(cliente);
        dynamoDBMapper.save(clienteEntity);
        return ClienteMapper.toDomain(clienteEntity);
    }
}