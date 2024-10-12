package com.sofixit.besthacksbackend.authentication.domain

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest
import com.sofixit.besthacksbackend.authentication.user.UserService
import com.sofixit.besthacksbackend.authentication.user.dto.UserResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthService/*(
    //private val passwordEncoder: PasswordEncoder,
    userService: UserService,
    //jwtService: JwtService,
    //val authenticationManager: AuthenticationManager,
    //activationTokenService: ActivationTokenService,
    //userInfoService: UserInfoService
) : com.sofixit.besthacksbackend.authentication.AuthService {
    override fun register(req: RegisterRequest) {
        val user = createUser(req)
        createUserInfo(req, user)
        sendActivationEmail(user)
    }

    private fun createUser(req: RegisterRequest): UserResponse {
        val userRequest: Any = UserRequest.builder()
            .email(req.email())
            .isGoogleAuthenticated(false)
            .password(passwordEncoder.encode(String(req.password())).toCharArray())
            .build()
        val user: Any = userService.create(userRequest)

        req.zeroPassword() // TODO RS make interface and create global handler for that
        userRequest.zeroPassword()
        return user
    }

    private fun createUserInfo(req: RegisterRequest, user: UserResponse) {
        val userInfoRequest: Any = UserInfoRequest.builder()
            .email(req.email())
            .firstname(req.firstName())
            .lastname(req.lastName())
            .userId(user.id())
            .build()
        userInfoService.create(userInfoRequest)
    }

    private fun sendActivationEmail(user: UserResponse) {
        val activationToken: Any = activationTokenService.createToken(user.id())
        AuthService.log.debug("Activation token created for user with id: {}", user.id())

        val activationLink: Any = authenticationProperties.getActivationLink() + activationToken.token()
        val message: Any = authenticationProperties.getActivationMessage() + activationLink
        emailService.sendMail(user.email(), "Account Activation", message)
        AuthService.log.debug("Activation email sent to user with id: {}", user.id())
    }

    override fun authenticate(req: AuthRequest): AuthResponse {
        val user: Any = userService.loadUserByUsername(req.email())
        AuthService.log.debug("User loaded with email: {}", user.getUsername())

        if (!user.isEnabled()) {
            throw UserNotActivatedException()
        }
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                req.email(), String(req.password()), user.getAuthorities()
            )
        )
        req.zeroPassword()
        AuthService.log.debug("User authenticated with email: {}", user.getUsername())

        val token: Any = jwtService.generateToken(JwtUser(user.getUsername()))
        AuthService.log.debug("Token generated for user with email: {}", user.getUsername())

        return AuthResponse(token)
    }

    val userService: UserService = userService
    val jwtService: JwtService = jwtService
    val activationTokenService: ActivationTokenService = activationTokenService
    val emailService: EmailService = emailService
    val authenticationProperties: AuthenticationProperties = authenticationProperties
    val userInfoService: UserInfoService = userInfoService
}*/