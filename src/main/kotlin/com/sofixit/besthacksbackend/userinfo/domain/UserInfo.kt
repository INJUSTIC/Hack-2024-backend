package com.sofixit.besthacksbackend.userinfo.domain;

import jakarta.persistence.*
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.Optional;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "users_info")
data class UserInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column private val id: UUID,
    @Column private val firstName: String,
    @Column private val lastName: String,
    @Column private val username: String,
    @Column private val information: String,
    @Column private val specialization: String,
    @Column private val userId: UUID
)
