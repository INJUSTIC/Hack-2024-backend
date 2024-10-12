package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.exception.UserNotFoundException
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserInfoService(private val userInfoRepository: UserInfoRepository, private val userInfoMapper: UserInfoMapper) :
    com.sofixit.besthacksbackend.userinfo.UserInfoService {
    override fun findByUsername(username: String): UserInfoResponse {
        return userInfoMapper.userInfoToUserInfoResponse(
            userInfoRepository.findByUsername(username).orElseThrow { UserNotFoundException("User with username $username doesn't exist") })
    }

    override fun findById(id: UUID): UserInfoResponse {
        return userInfoMapper.userInfoToUserInfoResponse(
            userInfoRepository.findById(id).orElseThrow { UserNotFoundException("User with id $id doesn't exist") })
    }

    override fun create(userInfoRequest: UserInfoRequest): UserInfoResponse {
        val userInfo = userInfoMapper.userInfoRequestToUserInfo(userInfoRequest)
        val savedUserInfo = userInfoRepository.save(userInfo)
        return userInfoMapper.userInfoToUserInfoResponse(savedUserInfo)
    }
}