package jwt;

import io.jsonwebtoken.Claims
import jwt.dto.JwtUser
import java.util.function.Function

interface JwtService {
    fun extractUsername(token: String): String

    fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T

    fun isTokenValid(token: String, user: JwtUser): Boolean

    fun generateToken(user: JwtUser): String

    fun generateToken(extraClaims: Map<String, Any>, user: JwtUser): String
}
