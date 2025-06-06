package com.sofixit.besthacksbackend.jwt.domain

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import com.sofixit.besthacksbackend.jwt.JwtService
import com.sofixit.besthacksbackend.jwt.dto.JwtUser
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function
import javax.crypto.SecretKey

@Component
class JwtService(val properties: JwtProperties) : JwtService {
    override fun extractUsername(token: String): String {
        return extractClaim(token) { obj: Claims -> obj.subject }
    }

    private fun extractExpiration(token: String): Date {
        return extractClaim(token) { obj: Claims -> obj.expiration }
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser().verifyWith(signInKey).build().parseSignedClaims(token).payload
    }

    override fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T {
        val claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }

    override fun isTokenValid(token: String, user: JwtUser): Boolean {
        val username = extractUsername(token)
        return (username == user.subject && !isTokenExpired(token))
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    override fun generateToken(user: JwtUser): String {
        return generateToken(HashMap(), user)
    }

    override fun generateToken(extraClaims: Map<String, Any>, user: JwtUser?): String {
        return Jwts.builder()
            .claims(extraClaims)
            .subject(user?.subject)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + properties.expirationTimeMillis))
            .signWith(signInKey)
            .compact()
    }

    private val signInKey: SecretKey
        get() {
            val keyBytes = Decoders.BASE64.decode(properties.secretKey)
            return Keys.hmacShaKeyFor(keyBytes)
        }
}