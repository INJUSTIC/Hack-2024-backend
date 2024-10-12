package com.sofixit.besthacksbackend.scraping.impl

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class PracujPlScraperTest {
  private val pracujPlScraper = PracujPlScraper()

  @Test
  fun `should scrape text data successfully`() {
    val result = runBlocking { pracujPlScraper.scrape("https://www.pracuj.pl/praca/starszy-specjalista-w-dziale-rozwoju-systemow-informatycznych-warszawa-ksiazeca-4,oferta,1003605588?s=ee0ff8ce&searchId=MTcyODcyOTE1MzQ1Ni41MzI1&ref=top_booster_3_1_1") }
    println(result)
    assert(result != PracujPlResult())
  }
}