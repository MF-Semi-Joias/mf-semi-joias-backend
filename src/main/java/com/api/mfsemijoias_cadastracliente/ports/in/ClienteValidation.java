package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import lombok.Data;
import lombok.Getter;

@Getter
public interface ClienteValidation {

    boolean isClienteValido(Cliente cliente);


}
