package com.sofixit.besthacksbackend.authentication.dto;

import jakarta.validation.constraints.NotEmpty;

data class RegisterRequest(
    @NotEmpty val username: String,
    @NotEmpty val password: String,
    @NotEmpty val firstname: String,
    @NotEmpty val lastname: String,
    @NotEmpty val specialization: String,
    @NotEmpty val information: String,
    @NotEmpty val phone: String,
    @NotEmpty val email: String
)