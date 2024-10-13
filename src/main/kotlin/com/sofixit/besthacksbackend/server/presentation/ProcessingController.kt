package com.sofixit.besthacksbackend.server.presentation

import com.sofixit.besthacksbackend.server.dto.ProcessingRequest
import com.sofixit.besthacksbackend.services.ProcessorService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/processing")
class ProcessingController(
  private val processorService: ProcessorService
) {
  @PostMapping("/process")
  suspend fun processUrl(@RequestBody request: ProcessingRequest, @AuthenticationPrincipal user: UserDetails) =
      processorService.processUrl(request, user.username)
}
