package com.lny.dynamodb.core.ports.out;

import com.lny.dynamodb.core.model.User;
import reactor.core.publisher.Mono;

public interface UserPort {

    Mono<User> findByEmail(String email);
}
