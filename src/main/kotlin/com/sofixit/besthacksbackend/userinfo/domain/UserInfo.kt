package com.sofixit.besthacksbackend.userinfo.domain;

import com.sofixit.besthacksbackend.userinfo.education.domain.Education
import com.sofixit.besthacksbackend.userinfo.experience.domain.Experience
import com.sofixit.besthacksbackend.userinfo.skill.domain.Skill
import jakarta.persistence.*
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "users_info")
data class UserInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column val id: UUID? = null,
    @Column val firstname: String,
    @Column val lastname: String,
    @Column val username: String,
    @Column val information: String,
    @Column val specialization: String,
    @Column val phone: String,
    @Column val email: String,
    @Column val userId: UUID,
    @OneToMany(mappedBy = "userInfo", cascade = [CascadeType.ALL], fetch = FetchType.EAGER) val skills: List<Skill> = emptyList(),
    @OneToMany(mappedBy = "userInfo", cascade = [CascadeType.ALL], fetch = FetchType.EAGER) val education: List<Education> = emptyList(),
    @OneToMany(mappedBy = "userInfo", cascade = [CascadeType.ALL], fetch = FetchType.EAGER) val experience: List<Experience> = emptyList()
)
