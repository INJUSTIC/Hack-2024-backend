package com.sofixit.besthacksbackend.userinfo.domain;

import jakarta.persistence.*
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "users_info")
data class UserInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column val id: UUID?,
    @Column val firstname: String,
    @Column val lastname: String,
    @Column val username: String,
    @Column val information: String,
    @Column val specialization: String,
    @Column val phone: String,
    @Column val email: String,
    @Column val userId: UUID
)
