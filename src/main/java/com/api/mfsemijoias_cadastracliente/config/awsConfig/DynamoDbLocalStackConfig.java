package com.api.mfsemijoias_cadastracliente.config.awsConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;

@Configuration
public class DynamoDbLocalStackConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        DynamoDbClientBuilder builder = DynamoDbClient.builder();
        builder.endpointOverride(URI.create("http://localhost:4566"));
        builder.region(Region.SA_EAST_1);
        builder.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("accesskey", "secretkey")));
        return builder.build();
    }
}