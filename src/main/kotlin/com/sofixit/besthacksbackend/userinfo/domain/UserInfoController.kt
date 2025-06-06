package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.web.bind.annotation.*
import java.util.*
@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
@RequestMapping("/api/user")
class UserInfoController (
    private val userInfoService: UserInfoService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): UserInfoResponse {
        return userInfoService.findById(id)
    }

    @GetMapping
    fun getByUsername(@RequestParam username: String): UserInfoResponse {
        return userInfoService.findByUsername(username)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody userInfoRequest: UserInfoRequest): UserInfoResponse {
        return userInfoService.update(id, userInfoRequest)
    }
}