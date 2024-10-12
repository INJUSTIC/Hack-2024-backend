package jwt.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.sofixit.besthacksbackend.jwt")
data class JwtProperties (
    val secretKey: String? = null,
    val expirationTimeMillis: Long = 0
)