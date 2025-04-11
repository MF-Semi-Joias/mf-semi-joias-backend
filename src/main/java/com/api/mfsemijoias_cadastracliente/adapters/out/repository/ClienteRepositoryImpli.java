package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClienteRepositoryImpli implements ClienteRepository {


    private final DynamoDBMapper dynamoDBMapper;

    public ClienteRepositoryImpli(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public void save(ClienteEntity clienteEntity) {
        dynamoDBMapper.save(clienteEntity);

    }

    @Override
    public void findById(UUID id) {

    }

    @Override
    public void findByEmail(String email) {

    }

    @Override
    public void findByCpf(String cpf) {

    }

    @Override
    public void findByNome(String nome) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void update(ClienteEntity clienteEntity) {

    }
}