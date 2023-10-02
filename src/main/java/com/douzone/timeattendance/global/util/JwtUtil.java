package com.douzone.timeattendance.global.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final Long EXPIRE_TIME = 12 * 60 * 60 * 1000L; //현재 리프레시 토큰을 사용하지 않으므로, 만료시간을 12시간으로 설정

    //application.yml에 정의된 비밀키
    @Value("${jwt.token.secret-key}")
    private String jwtSecretKey;

    public String createAccessToken(Long userId) {
        //토큰에 포함할 정보
        Claims claims = Jwts.claims()
                            .setSubject(String.valueOf(userId));

        //비밀키를 HS256 알고리즘으로 암호화
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));

        //토큰 생성
        return Jwts.builder()
                   .setClaims(claims)
                   .setIssuedAt(new Date(System.currentTimeMillis())) //토큰 생성시간
                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) //토큰 만료시간
                   .signWith(secretKey) //암호화 된 비밀키로 토큰 서명
                   .compact();
    }
}
