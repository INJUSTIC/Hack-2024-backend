package com.sofixit.besthacksbackend.authentication.user.dto;

import jakarta.validation.constraints.NotEmpty
import lombok.Builder

@Builder
data class UserRequest(
    @NotEmpty val password: String,
    @NotEmpty val username: String
)
