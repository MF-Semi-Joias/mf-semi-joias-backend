package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;

import java.util.List;

public interface ClienteService {


    void cadastrarCliente(Cliente cliente);

    void atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);

    List<Cliente> listarClientes();

    void buscarClientePorId(Long id);
}
