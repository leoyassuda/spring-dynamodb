package com.lny.dynamodb.adapter.out.database.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.lny.dynamodb.adapter.out.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private static final String USER_EMAIL_INDEX_NAME = "email-index";

    public Mono<UserEntity> findByEmail(String email) {
        DynamoDBQueryExpression<UserEntity> queryExpression = new DynamoDBQueryExpression<>();

        queryExpression
                .withKeyConditionExpression("email = :email")
                .withIndexName(USER_EMAIL_INDEX_NAME)
                .addExpressionAttributeValuesEntry(":email", new AttributeValue().withS(email))
                .withConsistentRead(false)
                .withScanIndexForward(false);

        CompletableFuture<UserEntity> userCompletableFuture
                = CompletableFuture.supplyAsync(
                () -> dynamoDBMapper.query(UserEntity.class, queryExpression)
                        .stream()
                        .findFirst()
                        .orElse(null));

        return Mono.fromFuture(userCompletableFuture);

    }
}
