package com.security.spring.security.jwt.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String SECRET_KEY = "0123456789ABCDEF0123456789ABCDEF"; // 32-byte key required

    public boolean validateJwtToken(String jwtToken, String username) {
        String extractUsername = extractUsername(jwtToken);
        return extractUsername.equals(username) && !isJwtTokenExpired(jwtToken);
    }

    private boolean isJwtTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJwt(jwtToken).getBody().getExpiration();
    }

    public String extractUsername(String jwtToken) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJwt(jwtToken).getBody().getSubject();
    }

    private Key getSignKey() {
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSignKey(), SignatureAlgorithm.ES256)
                .compact();
    }
}
