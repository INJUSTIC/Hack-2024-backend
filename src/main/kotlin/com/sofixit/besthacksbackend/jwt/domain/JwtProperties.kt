package com.sofixit.besthacksbackend.jwt.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.sofixit.besthacksbackend.jwt")
data class JwtProperties (
    var secretKey: String? = null,
    var expirationTimeMillis: Long = 0
)