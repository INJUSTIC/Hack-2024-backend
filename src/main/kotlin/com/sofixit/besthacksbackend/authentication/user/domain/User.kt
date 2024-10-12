package com.sofixit.besthacksbackend.authentication.user.domain;

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@NoArgsConstructor
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column private val id: UUID,
    @Column private val password: String,
    @Column(unique = true) private val username: String,
    @Column private val role: Role = Role.USER,
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return setOf(role)
    }

    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }
}
