package com.sofixit.besthacksbackend.exception

data class ErrorResponse(
    val message: String,
    val status: Int
)