package com.lny.dynamodb.adapter.out.database;

import com.lny.dynamodb.adapter.out.database.entity.UserEntity;
import com.lny.dynamodb.adapter.out.database.mapper.UserMapper;
import com.lny.dynamodb.adapter.out.database.repository.UserRepository;
import com.lny.dynamodb.core.model.User;
import com.lny.dynamodb.core.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserPort {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    @Override
    public Mono<User> findByEmail(String email) {

        final Mono<UserEntity> userEntity = userRepository.findByEmail(email);

        return userEntity.map(mapper::toModel);

    }
}
