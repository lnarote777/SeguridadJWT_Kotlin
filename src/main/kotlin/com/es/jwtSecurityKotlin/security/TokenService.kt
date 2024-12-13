package com.es.jwtSecurityKotlin.security
import com.nimbusds.jwt.JWTClaimsSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors
import java.time.temporal.Temporal

@Service
class TokenService {

    @Autowired
    private lateinit var jwtEncoder: JwtEncoder

    fun generarToken(authentication: Authentication): String {
        val roles : String = authentication.authorities
            .joinToString(" ") {it.authority}

        val payload: JwtClaimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(Instant.now())
            .expiresAt(Date().toInstant().plus(Duration.ofHours(1)))
            .subject(authentication.name)
            .claim("roles", roles)
            .build()

        return jwtEncoder.encode(JwtEncoderParameters.from(payload)).tokenValue
    }
}