package com.sofixit.besthacksbackend.userinfo.skill.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sofixit.besthacksbackend.userinfo.domain.UserInfo
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "skills")
data class Skill(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column private val id: UUID? = null,
    @Column private val content: String,
    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    @JsonIgnore
    private val userInfo: UserInfo
)