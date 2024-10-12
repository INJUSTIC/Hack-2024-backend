package com.sofixit.besthacksbackend.authentication;

import com.sofixit.besthacksbackend.authentication.dto.AuthRequest;
import com.sofixit.besthacksbackend.authentication.dto.AuthResponse;
import com.sofixit.besthacksbackend.authentication.dto.RegisterRequest;
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse

interface AuthService {
    fun register(req: RegisterRequest): UserInfoResponse
    fun authenticate(request: AuthRequest): AuthResponse
}
