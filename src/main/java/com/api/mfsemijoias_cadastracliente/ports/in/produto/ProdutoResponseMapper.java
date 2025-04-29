package com.api.mfsemijoias_cadastracliente.ports.in.produto;


import com.api.mfsemijoias_cadastracliente.adapters.in.response.ProdutoResponse;
import com.api.mfsemijoias_cadastracliente.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoResponseMapper {

    ProdutoResponseMapper INSTANCE = Mappers.getMapper(ProdutoResponseMapper.class);

    @Mapping(target = "id", source = "produto.id")
    ProdutoResponse toResponse(Produto produto);

    @Mapping(target = "id", source = "produtoResponse.id")
    Produto toDomain(ProdutoResponse produtoResponse);

}
