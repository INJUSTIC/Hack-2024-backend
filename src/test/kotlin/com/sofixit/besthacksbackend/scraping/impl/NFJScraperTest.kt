package com.sofixit.besthacksbackend.scraping.impl

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class NFJScraperTest {
    val nfjScraper = NFJScraper()

    @Test
    fun `should scrape text data successfully`() {
        val result = runBlocking { nfjScraper.scrape("https://nofluffjobs.com/pl/job/php-developer-mid-bigcom-spolka-z-o-o--wroclaw") }
        print(result)
        assert(result != NFJResult())
    }
}