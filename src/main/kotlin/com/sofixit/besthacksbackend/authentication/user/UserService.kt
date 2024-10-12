package com.sofixit.besthacksbackend.authentication.user;

import com.sofixit.besthacksbackend.authentication.user.dto.UserRequest
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun create(userRequest: UserRequest): UserResponse
    fun existsByUsername(username: String): Boolean
    fun findByUsername(username: String): UserResponse
}