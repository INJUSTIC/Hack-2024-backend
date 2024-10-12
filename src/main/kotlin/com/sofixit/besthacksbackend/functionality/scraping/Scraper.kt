package com.sofixit.besthacksbackend.functionality.scraping

import com.sofixit.besthacksbackend.domain.ScrapingResult

interface Scraper {
  suspend fun scrape(url: String): ScrapingResult
}