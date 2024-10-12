package com.sofixit.besthacksbackend.userinfo.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserInfoRepository : JpaRepository<UserInfo, UUID> {

    fun findByUsername(username: String): Optional<UserInfo>

    override fun findById(id: UUID): Optional<UserInfo>
}
