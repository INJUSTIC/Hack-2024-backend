package com.sofixit.besthacksbackend.templating

import com.sofixit.besthacksbackend.functionality.ai.AIResponse
import com.sofixit.besthacksbackend.functionality.templating.ResumeTemplatingEngine
import com.sofixit.besthacksbackend.functionality.templating.TemplateName
import kotlin.test.Ignore
import org.junit.jupiter.api.Test

class ResumeTemplatingEngineTest {
  private val resumeTemplatingEngine = ResumeTemplatingEngine()

  @Ignore
  @Test
  fun `should generate template`() {
    val expectedResult = """
      |<!DOCTYPE html>
      |<html lang="pl">
      |<head>
      |    <meta charset="UTF-8">
      |    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      |    <title>CV</title>
      |    <style>
      |        body {
      |            font-family: Arial, sans-serif;
      |            line-height: 1.6;
      |            color: #333;
      |            max-width: 800px;
      |            margin: 0 auto;
      |            padding: 20px;
      |        }
      |        h1, h2 {
      |            color: #2c3e50;
      |        }
      |        ul {
      |            padding-left: 20px;
      |        }
      |    </style>
      |</head>
      |<body>
      |<h1>CV</h1>
      |
      |<h2>O mnie</h2>
      |<p>I am a developer</p>
      |
      |<h2>Doświadczenie</h2>
      |<ul>
      |    <li>Developer at Google</li>
      |    <li>Developer at Facebook</li>
      |</ul>
      |
      |<h2>Edukacja</h2>
      |<ul>
      |    <li>Harvard University</li>
      |    <li>MIT</li>
      |</ul>
      |
      |<h2>Umiejętności</h2>
      |<ul>
      |    <li>Java</li>
      |    <li>Kotlin</li>
      |    <li>Python</li>
      |</ul>
      |</body>
      |</html>""".trimIndent().trim()

    val aiResponse = AIResponse(
      "I am a developer",
      listOf("Developer at Google", "Developer at Facebook"),
      listOf("Harvard University", "MIT"),
      listOf("Java", "Kotlin", "Python")
    )
    val userData = "John Doe"

    val template = resumeTemplatingEngine.generateTemplate(TemplateName.RESUME1, aiResponse, userData)

    assert(template.trim() == expectedResult)
  }
}