package com.sofixit.besthacksbackend.userinfo.domain

import jakarta.persistence.*
import java.util.*

data class Experience (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column private val id: UUID,
    @Column private val content: String,
    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private val userInfo: UserInfo
)