package com.sofixit.besthacksbackend.authentication.user.domain;

import com.sofixit.besthacksbackend.authentication.user.UserService
import com.sofixit.besthacksbackend.authentication.user.dto.UserRequest
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse
import com.sofixit.besthacksbackend.exception.UserAlreadyExistsException
import com.sofixit.besthacksbackend.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserService (
    val userRepository: UserRepository,
    val userMapper: UserMapper
) : UserService {
    override fun create(userRequest: UserRequest): UserResponse {
        if (existsByUsername(userRequest.username)) {
            throw UserAlreadyExistsException("User with username: ${userRequest.username} already exists")
        }
        val user = userMapper.userRequestToUser(userRequest)
        val savedUser = userRepository.save(user)
        return userMapper.userToUserResponse(savedUser)
    }

    override fun existsByUsername(username: String): Boolean {
        return userRepository.existsByUsername(username)
    }

    override fun findByUsername(username: String): UserResponse {
        return loadUserByUsername(username).let { userMapper.userToUserResponse(it) }
    }

    override fun loadUserByUsername(username: String): User {
        return userRepository.findByUsername(username).orElseThrow { UserNotFoundException("User with username $username doesn't exist") }
    }
}

