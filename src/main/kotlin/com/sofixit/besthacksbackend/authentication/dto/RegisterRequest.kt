package com.sofixit.besthacksbackend.authentication.dto;

import com.sofixit.besthacksbackend.userinfo.education.dto.EducationRequest
import com.sofixit.besthacksbackend.userinfo.experience.dto.ExperienceRequest
import com.sofixit.besthacksbackend.userinfo.skill.dto.SkillRequest
import jakarta.validation.constraints.NotEmpty;

data class RegisterRequest(
    @NotEmpty val username: String,
    @NotEmpty val password: String,
    @NotEmpty val firstname: String,
    @NotEmpty val lastname: String,
    @NotEmpty val specialization: String,
    @NotEmpty val information: String,
    @NotEmpty val phone: String,
    @NotEmpty val email: String,
    val skills: List<SkillRequest>,
    val education: List<EducationRequest>,
    val experience: List<ExperienceRequest>
)