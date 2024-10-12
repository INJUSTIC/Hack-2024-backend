package com.sofixit.besthacksbackend.userinfo

import com.sofixit.besthacksbackend.userinfo.domain.UserInfo
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import java.util.*

interface UserInfoService {
    fun findByUsername(username: String): UserInfoResponse

    fun findById(id: UUID): UserInfoResponse

    fun create(userInfoRequest: UserInfoRequest): UserInfoResponse
}