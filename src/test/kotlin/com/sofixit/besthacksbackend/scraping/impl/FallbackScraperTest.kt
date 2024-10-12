package com.sofixit.besthacksbackend.scraping.impl

import com.sofixit.besthacksbackend.domain.ScrapingResult
import com.sofixit.besthacksbackend.functionality.scraping.FallbackScraper
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FallbackScraperTest() {
  private val fallback = FallbackScraper()

  @Test
  fun `should scrape text data successfully`() {
    val result = runBlocking { fallback.scrape("https://www.pracuj.pl/praca/sql-developer-warszawa,oferta,1003607769") }
    print(result)
    assert(result != ScrapingResult(""))
  }
}
