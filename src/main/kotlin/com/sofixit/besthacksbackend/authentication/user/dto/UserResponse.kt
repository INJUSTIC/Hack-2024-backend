package com.sofixit.besthacksbackend.authentication.user.dto;

import java.util.UUID;

data class UserResponse(val id: UUID, private val username: String)
