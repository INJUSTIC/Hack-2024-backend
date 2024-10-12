package com.sofixit.besthacksbackend.userinfo.skill.dto

import jakarta.validation.constraints.NotEmpty

data class SkillRequest(
    @NotEmpty val content: String
)