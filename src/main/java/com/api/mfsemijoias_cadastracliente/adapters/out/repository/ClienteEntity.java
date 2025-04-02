package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBTable(tableName = "clientes"
) public class ClienteEntity {
    @DynamoDBAttribute(attributeName = "nome")
    private String nome;
    @DynamoDBAttribute(attributeName = "email")
    private String email;
    @DynamoDBAttribute(attributeName = "telefone")
    private String telefone;
    @DynamoDBAttribute(attributeName = "cpf")
    private String CPF;
    @DynamoDBAttribute(attributeName = "senha")
    private String senha;
    @DynamoDBAttribute(attributeName = "usuario")
    private String usuario;
    @DynamoDBAttribute(attributeName = "id")
    @DynamoDBHashKey(attributeName = "id")
    private Long id;

}





