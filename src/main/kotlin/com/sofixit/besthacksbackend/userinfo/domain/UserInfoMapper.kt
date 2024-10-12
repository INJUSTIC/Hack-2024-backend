package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserInfoMapper {
    fun userInfoToUserInfoResponse(userInfo: UserInfo): UserInfoResponse
    fun userInfoRequestToUserInfo(userInfo: UserInfoRequest): UserInfo
}