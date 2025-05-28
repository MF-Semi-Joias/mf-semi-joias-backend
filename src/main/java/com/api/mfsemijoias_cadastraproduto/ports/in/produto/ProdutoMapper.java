package com.api.mfsemijoias_cadastraproduto.ports.in.produto;



import com.api.mfsemijoias_cadastraproduto.adapters.out.entity.ProdutoEntity;
import com.api.mfsemijoias_cadastraproduto.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(target = "id", source = "produto.id")
    ProdutoEntity toEntity(Produto produto);

    @Mapping(target = "id", source = "produtoEntity.id")
    Produto toDomain(ProdutoEntity produtoEntity);
}
