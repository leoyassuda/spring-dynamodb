package com.lny.dynamodb.adapter.out.database.mapper;


import com.lny.dynamodb.adapter.out.database.entity.UserEntity;
import com.lny.dynamodb.core.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity toEntity(User userModel);

    User toModel(UserEntity userEntity);
}
