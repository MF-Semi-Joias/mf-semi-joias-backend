package com.api.mfsemijoias_cadastracliente.ports.in.produto;


import com.api.mfsemijoias_cadastracliente.adapters.in.request.ProdutoRequest;
import com.api.mfsemijoias_cadastracliente.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoRequestMapper {

    ProdutoRequestMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProdutoRequestMapper.class);

    @Mapping(target = "id", source = "produtoRequest.id")
    Produto toDomain(ProdutoRequest produtoRequest);

    @Mapping(target = "id", source = "produto.id")
    ProdutoRequest toRequest(Produto produto);

}
