package com.api.mfsemijoias_cadastracliente.adapters.out.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "produtos")
public class ProdutoEntity {

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;
    @DynamoDBAttribute(attributeName = "descricao")
    private String descricao;
    @DynamoDBAttribute(attributeName = "categoria")
    private String categoria;
    @DynamoDBAttribute(attributeName = "preco")
    private String preco;
    @DynamoDBAttribute(attributeName = "imagemUrl")
    private String imagemUrl;
    @DynamoDBAttribute(attributeName = "quantidadeEstoque")
    private String quantidadeEstoque;
    @DynamoDBAttribute(attributeName = "dataCadastro")
    private String dataCadastro;
    @DynamoDBAttribute(attributeName = "dataAtualizacao")
    private String dataAtualizacao;

}
