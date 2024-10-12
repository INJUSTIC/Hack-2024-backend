package com.sofixit.besthacksbackend.userinfo.dto

import com.sofixit.besthacksbackend.userinfo.education.domain.Education
import com.sofixit.besthacksbackend.userinfo.experience.domain.Experience
import com.sofixit.besthacksbackend.userinfo.skill.domain.Skill
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
    val skills: String,
    val education: String,
    val experience: String,
    val userId: UUID
)