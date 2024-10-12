package com.sofixit.besthacksbackend.userinfo.skill.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, UUID>