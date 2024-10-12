package com.sofixit.besthacksbackend.server.dto

import com.sofixit.besthacksbackend.functionality.templating.TemplateName

data class ProcessingRequest(
  val url: String, val templateName: TemplateName
)
