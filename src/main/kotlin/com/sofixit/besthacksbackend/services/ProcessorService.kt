package com.sofixit.besthacksbackend.services

import com.sofixit.besthacksbackend.functionality.ai.AnthropicClient
import com.sofixit.besthacksbackend.functionality.scraping.FallbackScraper
import com.sofixit.besthacksbackend.functionality.scraping.NFJScraper
import com.sofixit.besthacksbackend.functionality.scraping.PracujPlScraper
import com.sofixit.besthacksbackend.functionality.templating.ConvertApiClient
import com.sofixit.besthacksbackend.functionality.templating.ResumeTemplatingEngine
import com.sofixit.besthacksbackend.server.dto.ProcessingRequest
import java.time.Instant
import org.springframework.stereotype.Component

@Component
class ProcessorService(
  private val anthropicClient: AnthropicClient,
  private val resumeTemplatingEngine: ResumeTemplatingEngine,
  private val convertApiClient: ConvertApiClient
) {
  suspend fun processUrl(req: ProcessingRequest, username: String): String {
    val scrapedInformation = scrape(req.url)
    val userInfo = ""
    val optimizedInformation = anthropicClient.getOptimizedResume(scrapedInformation, userInfo)
    val templatedHTML = resumeTemplatingEngine.generateTemplate(req.templateName, optimizedInformation, userInfo)

    val filename = "CV-${Instant.now()}.html"
    return convertApiClient.getPdfUriFromHtml(filename, templatedHTML)
  }

  companion object {
    suspend fun scrape(url: String) = when {
      url.contains("pracuj.pl") -> PracujPlScraper()
      url.contains("nofluffjobs.com") -> NFJScraper()
      else -> FallbackScraper()
    }.scrape(url)
  }
}