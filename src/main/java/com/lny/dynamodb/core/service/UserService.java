package com.lny.dynamodb.core.service;

import com.lny.dynamodb.core.model.User;
import com.lny.dynamodb.core.ports.in.FindUserUseCase;
import com.lny.dynamodb.core.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService implements FindUserUseCase {

    private final UserPort userPort;

    @Override
    public Mono<User> findByEmail(String name) {
        return userPort.findByEmail(name);
    }
}
