package com.api.mfsemijoias_cadastracliente.domain.service;

import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteRepositoryImpli;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class ClienteServiceImpli implements ClienteService {

    private final ClienteRepositoryImpli clienteRepository;


    public ClienteServiceImpli(ClienteRepositoryImpli repositoryImpli) {
        this.clienteRepository = repositoryImpli;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {

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


