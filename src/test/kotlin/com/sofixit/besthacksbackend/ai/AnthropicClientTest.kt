package com.sofixit.besthacksbackend.ai

import com.sofixit.besthacksbackend.domain.ScrapingResult
import com.sofixit.besthacksbackend.functionality.ai.AnthropicClient
import kotlin.test.Ignore
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class AnthropicClientTest {
  val client = AnthropicClient("hehe")

  @Ignore
  @Test
  fun testGetAnthropicResponse() {
    val input = ScrapingResult("""
      |The user:
      |Nazywam się Bob Mitchell. Jestem studentem informatyki stosowanej na Politechnice Wrocławskiej.
      |Interesuję się programowaniem w języku Kotlin, Big Data oraz konteneryzacją.
      |
      |Education:
      |Infomatyka Stosowana na Politechnice Wrocławskiej 2022 - obecnie
      |
      |Experience:
      |Praktykant w firmie Januszex 2023 - 2024 (Tworzenie aplikacji webowych z backendem w Kotlinie)
      |Finalista Olimpiady informatycznej 2021
      |Wiele porjektów hobbystycznych wykożystująch Rusta, Gita, Dockera i Kubernetesa
      |
      |Skills:
      |Kotlin, Java, Rust, Docker, Kubernetes, Git, Scala, C++, Python, Adobe Creative Suite, Figma
      |
      |Company name:
      |Sofixit
      |
      |Job title:
      |Junior Kotlin Developer
      |
      |Description:
      |Firma Sofixit poszukuje programisty Kotlin do zespołu zajmującego się tworzeniem aplikacji ILUM.
      |Aplikacja ta ma za zadanie ułatwić zarządzaie Jobami Apache Spark na klastrze Kubernetesa.
      |
      |Tasks:
      |- Przygotowanie aplikacji do produkcji
      |- Optymalizacja aplikacji pod kątem wydajności
      |- Rozwój aplikacji w oparciu o nowe technologie
      |
      |Requirements:
      |- Kotlin
      |- Git
      |
    """.trimMargin())

    val response = runBlocking { client.getOptimizedResume(input, "") }
    println(response)
  }
}