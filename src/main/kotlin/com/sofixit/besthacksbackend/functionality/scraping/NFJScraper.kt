package com.sofixit.besthacksbackend.functionality.scraping

import com.sofixit.besthacksbackend.domain.ScrapingResult
import it.skrape.core.htmlDocument
import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape
import it.skrape.selects.html5.a
import it.skrape.selects.html5.div
import it.skrape.selects.html5.h1
import it.skrape.selects.html5.li
import it.skrape.selects.html5.section

data class NFJResult(
  var title: String = "",
  var company: String = "",
  var about: String = "",
  var requirements: List<String> = emptyList(),
  var goodToHaves: List<String> = emptyList(),
  var description: String = "",
  var tasks: List<String> = emptyList()
) {
  override fun toString() = """
    |These are the contents of the job offer:
    |
    |Stanowisko: $title
    |Firma: $company
    |O firmie: $about
    |Wymagania: ${requirements.joinToString()}
    |Mile widziane: ${goodToHaves.joinToString()}
    |Opis oferty: $description
    |Zadania: ${tasks.joinToString()}
    """.trimMargin()
}

class NFJScraper : Scraper {
  override suspend fun scrape(url: String) = skrape(AsyncFetcher) {
    request {
      this.url = url
    }
    extractIt<NFJResult> {
      htmlDocument {
        h1 {
          findFirst {
            it.title = text
          }
        }
        a {
          withAttribute = "data-cy" to "JobOffer_CompanyProfile"
          findFirst {
            it.company = text
          }
        }
        "common-posting-quote" {
          findFirst {
            it.about = text
          }
        }
        div {
          withAttribute = "id" to "posting-requirements"
          findFirst {
            section {
              findAll {
                assert(this.size == 2)
                this[0].li {
                  findAll {
                    it.requirements = this.map { it.text }
                  }
                }
                this[1].li {
                  findAll {
                    it.goodToHaves = this.map { it.text }
                  }
                }
              }
            }
          }
        }
        section {
          withAttribute = "id" to "posting-description"
          findFirst {
            it.description = text.trim().removePrefix("Opis oferty").trim()
          }
        }
        section {
          withAttribute = "id" to "posting-tasks"
          findFirst {
            li {
              findAll {
                it.tasks = this.map { it.text }
              }
            }
          }
        }
      }
    }
  }.let { ScrapingResult(it.toString()) }
}