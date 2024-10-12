package com.sofixit.besthacksbackend.userinfo.education.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EducationRepository : JpaRepository<Education, UUID>