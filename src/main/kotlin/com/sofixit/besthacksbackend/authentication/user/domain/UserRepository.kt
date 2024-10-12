package com.sofixit.besthacksbackend.authentication.user.domain;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findByUsername(email: String): Optional<User>
    fun existsByUsername(email: String): Boolean
}

