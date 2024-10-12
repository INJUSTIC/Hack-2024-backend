package com.sofixit.besthacksbackend.scraping.impl

import com.sofixit.besthacksbackend.scraping.Scraper
import it.skrape.core.htmlDocument
import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape
import it.skrape.selects.html5.div
import it.skrape.selects.html5.h1
import it.skrape.selects.html5.h2
import it.skrape.selects.html5.li
import it.skrape.selects.html5.section
import it.skrape.selects.html5.span

data class PracujPlResult(
  var title: String = "",
  var company: String = "",
  var position: String = "",
  var specializations: List<String> = emptyList(),
  var technologies: List<String> = emptyList(),
  var responsibilities: List<String> = emptyList(),
  var requirements: List<String> = emptyList(),
  var description: String = ""
) {
  override fun toString() = """
        |Stanowisko: $title
        |Firma: $company
        |Pozycja: $position
        |Specjalizacje: ${specializations.joinToString()}
        |Technologie: ${technologies.joinToString()}
        |Obowiązki: ${responsibilities.joinToString()}
        |Wymagania: ${requirements.joinToString()}
        |Opis firmy: $description
    """.trimMargin()
}

class PracujPlScraper : Scraper {
  override suspend fun scrape(url: String): PracujPlResult = skrape(AsyncFetcher) {
    request {
      this.url = url
    }
    extractIt<PracujPlResult> {
      htmlDocument {
        div {
          withId = "offer-header"
          findFirst { h1 { findFirst { it.title = text } } }
        }
        div {
          withId = "offer-header"
          findFirst { h2 { findFirst { it.company = text } } }
        }
        li {
          withAttribute = "data-test" to "sections-benefit-employment-type-name"
          findFirst { it.position = text }
        }
        li {
          withAttribute = "data-test" to "it-specializations"
          findFirst {
            div {
              findAll {
                it.specializations = this.map { it.text }
              }
            }
          }
        }
        span {
          withAttribute = "data-test" to "item-technologies-expected"
          findAll {
            it.technologies = this.map { it.text }
          }
        }
        section {
          withAttribute = "data-test" to "section-responsibilities"
          findFirst {
            li {
              findAll {
                it.responsibilities = this.map { it.text }
              }
            }
          }
        }
        section {
          withAttribute = "data-test" to "section-requirements"
          findFirst {
            li {
              findAll {
                it.requirements = this.map { it.text }
              }
            }
          }
        }
        section {
          withAttribute = "data-test" to "block-description"
          findFirst {
            li {
              findAll {
                it.description = this.joinToString("\n") { it.text }
              }
            }
          }
        }
      }
    }
  }
}