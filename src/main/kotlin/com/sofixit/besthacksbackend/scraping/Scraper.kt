package com.sofixit.besthacksbackend.scraping

interface Scraper {
  suspend fun scrape(url: String): Any
}

// public fun scrape(url: String): JobOfferInfo {
//   when {
//     url.contains("pracuj.pl") -> 
//   }
// }