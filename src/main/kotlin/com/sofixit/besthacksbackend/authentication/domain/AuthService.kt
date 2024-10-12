package com.sofixit.besthacksbackend.authentication.domain

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest
import com.sofixit.besthacksbackend.authentication.user.UserService
import com.sofixit.besthacksbackend.authentication.user.dto.UserRequest
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse
import com.sofixit.besthacksbackend.jwt.domain.JwtService
import com.sofixit.besthacksbackend.jwt.dto.JwtUser
import com.sofixit.besthacksbackend.userinfo.UserInfoService
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthService(
    private val passwordEncoder: PasswordEncoder,
    private val userService: UserService,
    private val jwtService: JwtService,
    private val userInfoService: UserInfoService,
    private val authenticationManager: AuthenticationManager
) : com.sofixit.besthacksbackend.authentication.AuthService {
    override fun register(req: RegisterRequest) {
        val user = createUser(req)
        createUserInfo(req, user)
    }

    private fun createUser(req: RegisterRequest): UserResponse {
        val userRequest = UserRequest(req.username, passwordEncoder.encode(req.password))
        val user = userService.create(userRequest)
        return user
    }

    private fun createUserInfo(req: RegisterRequest, user: UserResponse) {
        val userInfoRequest = UserInfoRequest(req.firstName, req.lastName, req.username, req.information, req.specialization, user.id)
        userInfoService.create(userInfoRequest)
    }

    override fun authenticate(req: AuthRequest): AuthResponse {
        val user = userService.loadUserByUsername(req.username)
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                req.username, req.password, user.authorities
            )
        )
        val token = jwtService.generateToken(JwtUser(user.username))
        return AuthResponse(token)
    }
}