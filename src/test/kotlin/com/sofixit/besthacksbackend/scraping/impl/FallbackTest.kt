package com.sofixit.besthacksbackend.scraping.impl

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FallbackTest() {
  val fallback = Fallback()

  @Test
  fun `should scrape text data successfully`() {
    val result = runBlocking { fallback.scrape("https://www.pracuj.pl/praca/sql-developer-warszawa,oferta,1003607769") }
    print(result)
    assert(result.isNotEmpty())
  }
}
