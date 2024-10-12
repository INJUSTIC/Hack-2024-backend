package com.sofixit.besthacksbackend.authentication.dto;

import jakarta.validation.constraints.NotEmpty;

data class RegisterRequest(
    @NotEmpty val username: String,
    @NotEmpty val firstName: String,
    @NotEmpty val lastName: String,
    @NotEmpty val specialization: String,
    @NotEmpty val information: String,
)