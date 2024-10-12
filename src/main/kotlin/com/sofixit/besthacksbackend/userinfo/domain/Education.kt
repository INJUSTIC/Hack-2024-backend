package com.sofixit.besthacksbackend.userinfo.domain

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "educations")
data class Education (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column private val id: UUID,
    @Column private val content: String,
    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private val userInfo: UserInfo
)