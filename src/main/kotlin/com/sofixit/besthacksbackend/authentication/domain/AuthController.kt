package com.sofixit.besthacksbackend.authentication.domain;

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
@RequestMapping("/api/auth")
data class AuthController(val authService: AuthService) {
    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest) {
        authService.register(registerRequest)
    }

    @PostMapping("/login")
    fun authenticate(@RequestBody authRequest: AuthRequest): AuthResponse {
        val response = authService.authenticate(authRequest)
        return response
    }
}