package com.sofixit.besthacksbackend.authentication.user.domain;

import org.springframework.security.core.GrantedAuthority;

enum class Role(private val authority: String) : GrantedAuthority {
    USER(Code.USER);

    override fun getAuthority(): String {
        return authority
    }

    object Code {
        const val USER: String = "ROLE_USER"
    }
}
