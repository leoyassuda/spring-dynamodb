package com.lny.dynamodb.adapter.in.http;

import com.lny.dynamodb.adapter.in.http.model.UserControllerMapper;
import com.lny.dynamodb.adapter.in.http.model.UserResponse;
import com.lny.dynamodb.core.model.User;
import com.lny.dynamodb.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    private final UserControllerMapper mapper;

    @GetMapping
    public Mono<ResponseEntity<UserResponse>> findByEmail(@RequestParam String email) {

        final Mono<User> user = userService.findByEmail(email);

        user.

        final Mono<UserResponse> userResponseMono = user.map(mapper::toResponse);

        return userResponseMono.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }
}
