package com.sofixit.besthacksbackend.userinfo.dto

import jakarta.validation.constraints.NotEmpty
import java.util.*

data class UserInfoRequest(
    @NotEmpty val firstname: String,
    @NotEmpty val lastname:  String,
    @NotEmpty val username: String,
    @NotEmpty val information: String,
    @NotEmpty val specialization: String,
    @NotEmpty val userId: UUID,
    )