package com.sofixit.besthacksbackend.authentication.dto;

import jakarta.validation.constraints.NotEmpty

data class AuthRequest(
    @NotEmpty val username: String,
    @NotEmpty val password: String
)
