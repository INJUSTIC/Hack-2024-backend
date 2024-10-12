package com.sofixit.besthacksbackend.scraping.impl

import com.sofixit.besthacksbackend.domain.ScrapingResult
import com.sofixit.besthacksbackend.functionality.scraping.NFJResult
import com.sofixit.besthacksbackend.functionality.scraping.NFJScraper
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class NFJScraperTest {
    val nfjScraper = NFJScraper()

    @Test
    fun `should scrape text data successfully`() {
        val result = runBlocking { nfjScraper.scrape("https://nofluffjobs.com/pl/job/php-developer-mid-bigcom-spolka-z-o-o--wroclaw") }
        print(result)
        assert(result != ScrapingResult(NFJResult().toString()))
    }
}