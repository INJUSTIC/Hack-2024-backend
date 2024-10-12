package com.sofixit.besthacksbackend.scraping.impl

import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.skrape
import org.springframework.stereotype.Component

@Component
class Fallback {
  suspend fun scrape(url: String): String = skrape(AsyncFetcher) {
    request {
      this.url = url
    }
  }.scrape().responseBody
}
