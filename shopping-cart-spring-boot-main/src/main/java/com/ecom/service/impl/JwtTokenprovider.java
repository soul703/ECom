package com.ecom.service.impl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenprovider {

    private final String SECRET_KEY = "COkakq4zIpxbQPGtd0/A1q7S4gYepCbY4ze5a2VB0EC671lZKNkUOYsJ3gGIPYEM";
    private final long EXPIRATION_TIME = 86400000;
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
