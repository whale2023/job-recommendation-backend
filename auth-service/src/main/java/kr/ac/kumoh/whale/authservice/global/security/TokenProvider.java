package kr.ac.kumoh.whale.authservice.global.security;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Slf4j
@RequiredArgsConstructor
@Service
public class TokenProvider {
    private final Environment env;

    public String validateJwtAndGetUserEmail(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(env.getProperty("token.secret"))
                .parseClaimsJws(token)
                .getBody();
        String userEmail = claims.getSubject();

        return userEmail;
    }
}
