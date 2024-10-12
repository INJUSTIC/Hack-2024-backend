package com.sofixit.besthacksbackend.userinfo.domain

import com.sofixit.besthacksbackend.exception.UserNotFoundException
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoRequest
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import com.sofixit.besthacksbackend.userinfo.education.domain.Education
import com.sofixit.besthacksbackend.userinfo.education.domain.EducationRepository
import com.sofixit.besthacksbackend.userinfo.experience.domain.Experience
import com.sofixit.besthacksbackend.userinfo.experience.domain.ExperienceRepository
import com.sofixit.besthacksbackend.userinfo.skill.domain.Skill
import com.sofixit.besthacksbackend.userinfo.skill.domain.SkillRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class UserInfoService(private val userInfoRepository: UserInfoRepository,
                      private val userInfoMapper: UserInfoMapper,
                      private val skillRepository: SkillRepository,
                      private val educationRepository: EducationRepository,
                      private val experienceRepository: ExperienceRepository
) :
    com.sofixit.besthacksbackend.userinfo.UserInfoService {
    override fun findByUsername(username: String): UserInfoResponse {
        return userInfoMapper.userInfoToUserInfoResponse(
            userInfoRepository.findByUsername(username).orElseThrow { UserNotFoundException("User with username $username doesn't exist") })
    }

    override fun findById(id: UUID): UserInfoResponse {
        val userInfo = userInfoRepository.findById(id)
        println(userInfo)
        return userInfoMapper.userInfoToUserInfoResponse(
            userInfoRepository.findById(id).orElseThrow { UserNotFoundException("User with id $id doesn't exist") })
    }

    override fun create(userInfoRequest: UserInfoRequest): UserInfoResponse {
        val userInfo = userInfoMapper.userInfoRequestToUserInfo(userInfoRequest)
        val savedUserInfo = userInfoRepository.save(userInfo)
        return userInfoMapper.userInfoToUserInfoResponse(savedUserInfo)
    }
}