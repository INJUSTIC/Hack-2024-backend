package com.sofixit.besthacksbackend.functionality.scraping

import com.sofixit.besthacksbackend.domain.ScrapingResult
import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.skrape
import org.springframework.stereotype.Component

@Component
class FallbackScraper : Scraper {
  override suspend fun scrape(url: String) = skrape(AsyncFetcher) {
    request {
      this.url = url
    }
  }.scrape().let {
    "This a HTML content of the page with the job offer:\n\n${it.responseBody}"
  }.let { ScrapingResult(it) }
}
