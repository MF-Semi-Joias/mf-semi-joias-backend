package com.api.mfsemijoias_cadastraproduto.infra;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DynamoDBInitializer {

    private AmazonDynamoDB dynamoDB;

    @PostConstruct
    public void init() {
        this.dynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("mock_access_key", "mock_secret_key")))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "sa-east-1"))
                .build();

        try {
            dynamoDB.listTables();
            System.out.println("Conexão com o DynamoDB LocalStack estabelecida com sucesso.");
            createprodutoTableIfNotExists();
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao DynamoDB LocalStack: " + e.getMessage());
        }
    }

    private void createprodutoTableIfNotExists() {
        String tableName = "produtos";

        if (!dynamoDB.listTables().getTableNames().contains(tableName)) {
            System.out.println("Tabela 'Produto' não encontrada. Criando tabela...");

            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(new KeySchemaElement("id", KeyType.HASH)) // Chave primária
                    .withAttributeDefinitions(
                            new AttributeDefinition("id", ScalarAttributeType.S) // Tipo String para a chave primária
                    )
                    .withProvisionedThroughput(new ProvisionedThroughput(5L, 5L)); // Capacidade provisionada para a tabela

            dynamoDB.createTable(request);
            System.out.println("Tabela 'Produto' criada com sucesso.");
        } else {
            System.out.println("Tabela 'Produto' já existe.");
        }
    }
}