package com.cc.campuscircle.security;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    private static final String SECRET_KEY="";
    private static final long JWT_EXPIRATION_MS=24*60*60*1000;

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        Claims claims=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
    public String extractEmail(String token){
        return extractClaim(token,Claims::getSubject);
    }

}
