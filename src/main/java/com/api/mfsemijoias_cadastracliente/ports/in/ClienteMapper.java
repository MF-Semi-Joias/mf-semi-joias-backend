package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.out.repository.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

    @Mapper
    public interface ClienteMapper {
        ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

        ClienteEntity toEntity(Cliente cliente);

        Cliente toDomain(ClienteEntity clienteEntity);
    }