package com.sofixit.besthacksbackend.authentication.user.domain;

import com.sofixit.besthacksbackend.authentication.user.dto.UserRequest;
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {
    @Mapping(target = "id", source = "id")
    fun userToUserResponse(user: User): UserResponse
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.sofixit.besthacksbackend.authentication.user.domain.Role.USER)")
    fun userRequestToUser(user: UserRequest): User
}

