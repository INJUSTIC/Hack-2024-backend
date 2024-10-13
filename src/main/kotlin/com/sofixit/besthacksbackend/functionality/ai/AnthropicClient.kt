package com.sofixit.besthacksbackend.functionality.ai

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sofixit.besthacksbackend.domain.ScrapingResult
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import java.time.Duration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AnthropicClient(
  @Value("\${anthropic.apiCode}") private val apiCode: String,
) {
  private val objectMapper = jacksonObjectMapper()
  private val headers = getHeaders(apiCode)
  private val restTemplate: RestTemplate = RestTemplateBuilder()
    .setReadTimeout(Duration.ofSeconds(60))
    .setConnectTimeout(Duration.ofSeconds(30))
    .build()

  suspend fun getOptimizedResume(scrapingResult: ScrapingResult, userInfo: UserInfoResponse): AIResponse {
    val query = "${scrapingResult.inner}\n\n\n${userInfo.toAiString()}"
    return AIResponse(getAnthropicResponse(query))
  }

  private suspend fun getAnthropicResponse(query: String, maxTokens: Int? = null): String {
    val _maxTokens = maxTokens ?: DEFAULT_MAX_TOKENS
    val requestBody = mapOf(
      "model" to "claude-3-5-sonnet-20240620",
      "max_tokens" to _maxTokens,
      "messages" to listOf(mapOf("role" to "user", "content" to query)),
      "system" to SYSTEM_PROMPT
    )

    val request = HttpEntity(requestBody, headers)

    val response = withContext(Dispatchers.IO) {
      try {
        restTemplate.exchange(
          API_URL, HttpMethod.POST, request, String::class.java
        )
      } catch (e: Exception) {
        throw RuntimeException("Failed to get response from Anthropic API ${e.message}")
      }
    }.let {
      objectMapper.readTree(it.body)
    }.let {
      it["content"][0]["text"].asText()
    }

    return response
  }

  companion object {
    const val DEFAULT_MAX_TOKENS = 1000
    const val API_URL = "https://api.anthropic.com/v1/messages"
    val SYSTEM_PROMPT = """You are an assistant specializing in optimizing job resumes that would make the candidate more likely to get hired.
      |
      |Task:
      |- Use provided information and provide optimized (rewritten to be more attractive, properly structured, with important information emphasized, and sorted by relevancy) resume content.
      |
      |Language Requirements:
      |- Both the resume and the job offer will be provided in Polish.
      |- Your response must match the job offer language.
      |
      |Guidelines:
      |1. Do not fabricate or alter the candidate's skills or experiences.
      |2. Highlight and prioritize the candidate's skills and experiences that align with the job offer requirements.
      |3. Structure the optimized resume in the following format (Do not change the order of the section and do not translate the section names to other languages):
      |
      |OVERVIEW:
      |Provide a concise paragraph summarizing the candidate, suitable for the 'About Me' section (do not reveal that this resume was tailored for this job offer).
      |
      |EXPERIENCE:
      |List the candidate's professional and non-professional experiences, each on a new line. Provide information about what the candidate did as a continuous text in the same line (try to avoid lying, but creatively expand short statements).
      |
      |EDUCATION:
      |List the candidate's education, each on a new line. Provide information about what the candidate did during their studies as a continuous text in the same line (try to avoid lying, but creatively expand short statements).
      |
      |SKILLS:
      |List the candidate's skills, each on a new line. Creatively expand short statements, but do not lie.
      |
      |Additional Information:
      |Below are the details provided by the user:
      |""".trimMargin()

    fun getHeaders(apiCode: String) = HttpHeaders().apply {
      contentType = MediaType.APPLICATION_JSON
      set("anthropic-version", "2023-06-01")
      set("x-api-key", apiCode)
    }
  }
}