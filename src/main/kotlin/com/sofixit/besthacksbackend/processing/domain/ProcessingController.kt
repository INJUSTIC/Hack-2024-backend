package com.sofixit.besthacksbackend.processing.domain

import com.sofixit.besthacksbackend.processing.dto.ProcessingRequest
import com.sofixit.besthacksbackend.services.ProcessorService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
@RequestMapping("/api/processing")
class ProcessingController(
  private val processorService: ProcessorService
) {
  @PostMapping("/process")
  suspend fun processUrl(@RequestBody request: ProcessingRequest, @AuthenticationPrincipal user: UserDetails) =
      processorService.processUrl(request, user.username)
}
