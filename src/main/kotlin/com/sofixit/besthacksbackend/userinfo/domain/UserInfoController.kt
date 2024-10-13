package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserInfoController (
    private val userInfoService: UserInfoService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): UserInfoResponse {
        return userInfoService.findById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody userInfoRequest: UserInfoRequest): UserInfoResponse {
        return userInfoService.update(id, userInfoRequest)
    }
}