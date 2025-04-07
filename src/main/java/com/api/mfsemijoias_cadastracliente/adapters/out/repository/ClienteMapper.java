package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteMapper {

    public static ClienteEntity toEntity(Cliente cliente) {

        return null;
    }

    public static Cliente toDomain(ClienteEntity clienteEntity) {
        return null;
    }
}
