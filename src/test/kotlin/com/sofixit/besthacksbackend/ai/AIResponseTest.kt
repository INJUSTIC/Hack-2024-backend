package com.sofixit.besthacksbackend.ai

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test

class AIResponseTest {
  @Test
  fun `should correctly parse the response string`() {
    val about = "Ambitny student informatyki stosowanej na Politechnice Wrocławskiej"
    val experience = listOf(
      "Praktykant w firmie Januszex (2023 - 2024) - Tworzenie aplikacji webowych z backendem w Kotlinie",
      "Finalista Olimpiady Informatycznej (2021)",
      "Realizacja licznych projektów hobbystycznych z wykorzystaniem Rusta, Gita, Dockera i Kubernetesa"
    )
    val education = listOf(
      "Informatyka Stosowana, Politechnika Wrocławska (2022 - obecnie)"
    )
    val skills = listOf(
      "Kotlin",
      "Git",
      "Java",
      "Docker",
      "Kubernetes"
    )

    val responseString= """
      |OVERVIEW:
      |$about
      |
      |EXPERIENCE:
      |${experience.joinToString("\n|")}
      |
      |EDUCATION:
      |${education.joinToString("\n|")}
      |
      |SKILLS:
      |${skills.joinToString("\n|")}
      |""".trimMargin()

    val response = AIResponse(responseString)

    assert(response.about == about)
    assert(response.experience == experience)
    assert(response.education == education)
    assert(response.skills == skills)
  }

  @Test
  fun `should convert the object to json`() {
    val about = "Ambitny student informatyki stosowanej na Politechnice Wrocławskiej"
    val experience = listOf(
      "Praktykant w firmie Januszex (2023 - 2024) - Tworzenie aplikacji webowych z backendem w Kotlinie",
      "Finalista Olimpiady Informatycznej (2021)",
      "Realizacja licznych projektów hobbystycznych z wykorzystaniem Rusta, Gita, Dockera i Kubernetesa"
    )
    val education = listOf(
      "Informatyka Stosowana, Politechnika Wrocławska (2022 - obecnie)"
    )
    val skills = listOf(
      "Kotlin",
      "Git",
      "Java",
      "Docker",
      "Kubernetes"
    )
    val responseString= """
      |OVERVIEW:
      |$about
      |
      |EXPERIENCE:
      |${experience.joinToString("\n|")}
      |
      |EDUCATION:
      |${education.joinToString("\n|")}
      |
      |SKILLS:
      |${skills.joinToString("\n|")}
      |""".trimMargin()
    val objectMapper = jacksonObjectMapper()

    val response = AIResponse(responseString)

    println(objectMapper.writeValueAsString(response))
  }
}