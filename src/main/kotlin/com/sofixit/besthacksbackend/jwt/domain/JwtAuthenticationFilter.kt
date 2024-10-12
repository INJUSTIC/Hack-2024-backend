package com.sofixit.besthacksbackend.jwt.domain

import com.sofixit.besthacksbackend.jwt.dto.JwtUser
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter (
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authorizationHeader.split(" ")[1].trim();

        try {
            val username = jwtService.extractUsername(token)
            if (SecurityContextHolder.getContext().authentication == null) {
                val userDetails = userDetailsService.loadUserByUsername(username)
                val jwtUser = JwtUser(userDetails.username)
                if (jwtService.isTokenValid(token, jwtUser)) {
                    val authenticationToken =
                        UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                    authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                    val context = SecurityContextHolder.createEmptyContext()
                    context.authentication = authenticationToken
                    SecurityContextHolder.setContext(context)
                }
            }
        } catch (e: UnsupportedJwtException) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The JWT token is unsupported.")
            return
        } catch (e: ExpiredJwtException) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The JWT token is expired.")
            return
        } catch (e: MalformedJwtException) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "The JWT token is malformed.")
            return
        } catch (e: Exception) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the JWT token.")
            return
        }

        filterChain.doFilter(request, response)
    }
}