package com.api.mfsemijoias_cadastracliente.domain.service;

import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteRepository;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteValidation;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class ClienteServiceImpli implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final ClienteValidation clienteValidation;
    private  ClienteEntity clienteEntity;


    public ClienteServiceImpli(ClienteRepository clienteRepository, ClienteMapper clienteMapper, ClienteValidation clienteValidation) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.clienteValidation = clienteValidation;
    }
    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteValidation.clienteValido(cliente);
        clienteEntity = clienteMapper.toEntity(cliente);
        clienteRepository.save(clienteEntity);

    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {

    }

    @Override
    public void deletarCliente(Long id) {

    }

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }
}


