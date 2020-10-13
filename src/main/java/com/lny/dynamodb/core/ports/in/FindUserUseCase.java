package com.lny.dynamodb.core.ports.in;

import com.lny.dynamodb.core.model.User;
import reactor.core.publisher.Mono;

public interface FindUserUseCase {
    /**
     * Find all users
     *
     * @return
     */
    Mono<User> findByEmail(String name);
}
