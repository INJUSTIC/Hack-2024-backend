package com.sofixit.besthacksbackend.userinfo.dto

import java.util.UUID

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
) {
  fun toAiString() = """
    |These are the details provided by the user:
    |
    |Specialization: $specialization
    |General information: $information
    |Skills: $skills
    |Education: $education
    |Experience: $experience
    |""".trimMargin()
}