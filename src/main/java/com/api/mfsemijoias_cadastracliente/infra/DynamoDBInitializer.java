package com.api.mfsemijoias_cadastracliente.infra;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collections;

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
            createClienteTableIfNotExists();
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao DynamoDB LocalStack: " + e.getMessage());
        }
    }

    private void createClienteTableIfNotExists() {
        String tableName = "clientes";

        if (!dynamoDB.listTables().getTableNames().contains(tableName)) {
            System.out.println("Tabela 'Cliente' não encontrada. Criando tabela...");

            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(new KeySchemaElement("id", KeyType.HASH)) // Chave primária
                    .withAttributeDefinitions(new AttributeDefinition("id", ScalarAttributeType.S)) // Tipo String
                    .withProvisionedThroughput(new ProvisionedThroughput(5L, 5L)); // Capacidade provisionada

            dynamoDB.createTable(request);
            System.out.println("Tabela 'Cliente' criada com sucesso.");
        } else {
            System.out.println("Tabela 'Cliente' já existe.");
        }
    }

    public AmazonDynamoDB getDynamoDB() {
        return dynamoDB;
    }
}