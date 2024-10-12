package com.sofixit.besthacksbackend.userinfo.education.dto

import jakarta.validation.constraints.NotEmpty

data class EducationRequest(
    @NotEmpty val content: String
)