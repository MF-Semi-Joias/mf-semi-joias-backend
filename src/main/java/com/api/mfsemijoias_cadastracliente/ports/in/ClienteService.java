package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

public interface ClienteService {


    void cadastrarCliente(Cliente cliente);

    void atualizarCliente(UUID id, Cliente cliente);

    void deletarCliente(UUID id);

    List<Cliente> listarClientes();

    Cliente buscarClientePorId(UUID id);


    Cliente buscarClientePorUsuario(String usuario);
}
