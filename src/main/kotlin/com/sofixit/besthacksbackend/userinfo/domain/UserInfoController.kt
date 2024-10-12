package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/user")
internal class UserInfoController (
    private val userInfoService: UserInfoService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): UserInfoResponse {
        val userInfo: UserInfoResponse = userInfoService.findById(id)
        return userInfo
    }
}