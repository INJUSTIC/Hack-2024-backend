package com.sofixit.besthacksbackend.userinfo.dto

import java.util.*

data class UserInfoResponse(
    val id: UUID,
    val username: String,
    val firstname: String,
    val lastname: String,
    val information: String,
    val specialization: String,
    val phone: String,
    val email: String,
    val userId: UUID
)