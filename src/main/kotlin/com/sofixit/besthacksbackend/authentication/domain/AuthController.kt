package com.sofixit.besthacksbackend.authentication.domain;

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
@RequestMapping("/api/auth")
class AuthController(val authService: AuthService) {
    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest): ResponseEntity<UserInfoResponse> {
        val response = authService.register(registerRequest)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun authenticate(@RequestBody authRequest: AuthRequest): AuthResponse {
        val response = authService.authenticate(authRequest)
        return response
    }
}