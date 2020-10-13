package com.lny.dynamodb.adapter.in.http.model;

import com.lny.dynamodb.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface UserControllerMapper {

//    @Mapping(target = "fullname", expression = "java(user.getFullname())")

    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    UserResponse toResponse(User user);
}
