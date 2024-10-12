package com.sofixit.besthacksbackend.userinfo.experience.dto

import jakarta.validation.constraints.NotEmpty

data class ExperienceRequest(
    @NotEmpty val content: String
)