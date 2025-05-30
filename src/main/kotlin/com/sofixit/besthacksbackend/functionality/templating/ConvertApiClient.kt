package com.sofixit.besthacksbackend.functionality.templating

import com.convertapi.client.Config
import com.convertapi.client.ConvertApi
import com.convertapi.client.Param
import java.io.ByteArrayInputStream
import java.io.InputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ConvertApiClient(
  @Value("\${convertApi.apiKey}") private val apiKey: String,
) {
  suspend fun getPdfUriFromHtml(filename: String, content: String): String = withContext(Dispatchers.IO) {
    ConvertApi.convert(
      "html", "pdf",
      arrayOf(
        Param("file", stringToInputStream(content), filename),
        Param("JavaScript", "false"), Param("PageSize", "a4"),
        Param("MarginTop", "0"),
        Param("MarginRight", "0"),
        Param("MarginBottom", "0"),
        Param("MarginLeft", "0"),
        Param("CompressPDF", "true"),
      ),
      Config.defaults(apiKey)
    ).get()
  }.urls()[0] ?: throw IllegalStateException("No URL in the response")

  companion object {
    private fun stringToInputStream(input: String): InputStream {
      return ByteArrayInputStream(input.toByteArray())
    }
  }
}