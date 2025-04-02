package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class ClienteEntity {
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private String senha;
    private String usuario;
    private Long id;

    @DynamoDbPartitionKey
    public Long getId() {
        return id;
    }
}


