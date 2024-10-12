package com.sofixit.besthacksbackend.userinfo.dto

import com.sofixit.besthacksbackend.userinfo.education.dto.EducationRequest
import com.sofixit.besthacksbackend.userinfo.experience.dto.ExperienceRequest
import com.sofixit.besthacksbackend.userinfo.skill.dto.SkillRequest
import jakarta.validation.constraints.NotEmpty
import java.util.*

data class UserInfoRequest(
    @NotEmpty val firstname: String,
    @NotEmpty val lastname:  String,
    @NotEmpty val username: String,
    @NotEmpty val information: String,
    @NotEmpty val specialization: String,
    @NotEmpty val phone: String,
    @NotEmpty val email: String,
    val skills: List<SkillRequest>,
    val education: List<EducationRequest>,
    val experience: List<ExperienceRequest>,
    @NotEmpty val userId: UUID,
)