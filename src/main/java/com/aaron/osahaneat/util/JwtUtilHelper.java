package com.aaron.osahaneat.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtilHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jwt = Jwts.builder().setSubject(data).signWith(secretKey).compact();

        return jwt;
    }

}
