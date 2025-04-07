package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ClienteRepositoryImpli implements ClienteRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final ClienteService.ClienteMapper clienteMapper;
    private ClienteEntity clienteEntity;


    @Override
    public Cliente save(Cliente cliente) {
        clienteEntity = clienteMapper.toEntity(cliente);
        dynamoDBMapper.save(clienteEntity);
        return cliente;
    }

    @Override
    public Cliente findById(Long id) {
         clienteEntity = dynamoDBMapper.load(ClienteEntity.class, id);
        return clienteMapper.toDomain(clienteEntity);
    }


    @Override
    public Cliente findByEmail(String email) {
        clienteEntity = dynamoDBMapper.load(ClienteEntity.class, email);
        return clienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        clienteEntity = dynamoDBMapper.load(ClienteEntity.class, cpf);
        return clienteMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente findByNome(String nome) {
        clienteEntity = dynamoDBMapper.load(ClienteEntity.class, nome);
        return clienteMapper.toDomain(clienteEntity);
        }

    @Override
    public Cliente deleteById(Long id) {
        clienteEntity = dynamoDBMapper.load(ClienteEntity.class, id);
        dynamoDBMapper.delete(clienteEntity);
        return clienteMapper.toDomain(clienteEntity);

    }

    @Override
    public Cliente update(Cliente cliente) {
        clienteEntity = clienteMapper.toEntity(cliente);
        dynamoDBMapper.save(cliente);
        return cliente;
    }

}
