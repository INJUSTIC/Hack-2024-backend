package com.sofixit.besthacksbackend.functionality.ai

data class AIResponse(
  val about: String,
  val experience: List<String>,
  val education: List<String>,
  val skills: List<String>,
) {
  constructor(responseString: String) : this(
    about = extractSection(responseString, "OVERVIEW"),
    experience = if (responseString.contains("DOŚWIADCZENIE")) { extractListSection(responseString, "DOŚWIADCZENIE") } else {
      extractListSection(responseString, "EXPERIENCE")
    },
    education = if(responseString.contains("EDUKACJA")) { extractListSection(responseString, "EDUKACJA") } else{
      extractListSection(responseString, "EDUCATION")
    },
    skills = if(responseString.contains("UMIEJĘTNOŚCI")) { extractListSection(responseString, "UMIEJĘTNOŚCI") } else {
      extractListSection(responseString, "SKILLS")
    }
  )

  companion object {
    private fun extractSection(text: String, section: String): String {
      val regex = Regex("(?i)$section:\\s*(.*?)\\s*(?=OVERVIEW:|EXPERIENCE:|EDUCATION:|SKILLS:|$)", RegexOption.DOT_MATCHES_ALL)
      val match = regex.find(text)
      return match?.groups?.get(1)?.value?.trim() ?: ""
    }

    private fun extractListSection(text: String, section: String): List<String> {
      val sectionContent = extractSection(text, section)
      return sectionContent.lines().map { it.trim() }.filter { it.isNotEmpty() }
    }
  }
}