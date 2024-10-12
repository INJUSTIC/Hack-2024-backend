package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.stereotype.Component

@Component
class UserInfoMapper {
    fun userInfoToUserInfoResponse(userInfo: UserInfo): UserInfoResponse {
        return UserInfoResponse(
            id = userInfo.id!!,
            username = userInfo.username,
            email = userInfo.email,
            firstname = userInfo.firstname,
            lastname = userInfo.lastname,
            phone = userInfo.phone,
            information = userInfo.information,
            specialization = userInfo.specialization,
            experience = userInfo.experience,
            education = userInfo.education,
            skills = userInfo.skills,
            userId = userInfo.userId
        )
    }

    fun userInfoRequestToUserInfo(userInfoRequest: UserInfoRequest): UserInfo {
        return UserInfo(
            username = userInfoRequest.username,
            email = userInfoRequest.email,
            firstname = userInfoRequest.firstname,
            lastname = userInfoRequest.lastname,
            phone = userInfoRequest.phone,
            information = userInfoRequest.information,
            specialization = userInfoRequest.specialization,
            userId = userInfoRequest.userId
        )
    }
}