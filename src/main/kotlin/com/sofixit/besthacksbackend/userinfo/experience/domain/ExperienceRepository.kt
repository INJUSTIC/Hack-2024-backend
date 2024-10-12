package com.sofixit.besthacksbackend.userinfo.experience.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, UUID>