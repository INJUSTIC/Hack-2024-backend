package com.sofixit.besthacksbackend.authentication;

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest;
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse;
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest;

interface AuthService {
    fun register(req: RegisterRequest)
    fun authenticate(request: AuthRequest): AuthResponse
}
