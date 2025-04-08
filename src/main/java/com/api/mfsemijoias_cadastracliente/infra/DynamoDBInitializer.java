package com.api.mfsemijoias_cadastracliente.infra;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DynamoDBInitializer {

    private final AmazonDynamoDB dynamoDB;

    public DynamoDBInitializer() {
        this.dynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("mock_access_key", "mock_secret_key")))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "sa-east-1"))
                .build();
    }

    @PostConstruct
    public void init() {
        String tableName = "clientes";

        try {
            // Verifica se a tabela já existe
            dynamoDB.describeTable(tableName);
            System.out.println("Tabela " + tableName + " já existe.");
        } catch (ResourceNotFoundException e) {
            // Cria a tabela caso não exista
            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(new KeySchemaElement("id", KeyType.HASH))
                    .withAttributeDefinitions(new AttributeDefinition("id", ScalarAttributeType.N))
                    .withBillingMode(BillingMode.PAY_PER_REQUEST);

            dynamoDB.createTable(request);
            System.out.println("Tabela " + tableName + " criada com sucesso.");
        }
    }
}