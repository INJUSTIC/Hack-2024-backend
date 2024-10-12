package com.sofixit.besthacksbackend.authentication.user.domain;

import com.sofixit.besthacksbackend.authentication.user.dto.UserRequest;
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    fun userToUserResponse(user: User): UserResponse
    fun userRequestToUser(user: UserRequest): User
}

