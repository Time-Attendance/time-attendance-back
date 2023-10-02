package com.douzone.timeattendance.global.auth;

import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.exception.auth.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    //application.yml에 정의된 비밀키
    @Value("${jwt.token.secret-key}")
    private String jwtSecretKey;

    /**
     * 핸들러 메서드에 LoginUser 어노테이션과 AuthInfo 클래스가 적용된 메서드인지 확인합니다.
     *
     * @param parameter the method parameter to check
     * @return LoginUser 어노테이션과 AuthInfo 클래스가 적용되어 있다면 true
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasLoginUserAnnotation = parameter.hasParameterAnnotation(LoginUser.class);
        boolean hasAuthInfoType = AuthInfo.class.isAssignableFrom(parameter.getParameterType());

        return hasLoginUserAnnotation && hasAuthInfoType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        //TODO: 인터셉터에서 토큰 유효성 검사
        //요청 헤더의 Authorization에 담긴 토큰을 가져옵니다.
        String jws = webRequest.getHeader("Authorization");
        //토큰 없으면 예외 발생
        if (jws == null || jws.equals("")) {
            throw new UnauthorizedException();
        }

        //비밀키를 HS256 알고리즘으로 암호화
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));

        try {
            //토큰 검증
            Jws<Claims> claims = Jwts.parserBuilder()
                                     .setSigningKey(secretKey)
                                     .build()
                                     .parseClaimsJws(extractToken(jws));

            //토큰에서 정보 추출
            String userId = claims.getBody()
                                  .getSubject();
            return new AuthInfo(Long.valueOf(userId));
        } catch (JwtException e) { //유효하지 않은 토큰일 시 예외 발생
            throw new UnauthorizedException();
        }
    }

    /**
     * 토큰 접두사인 `Bearer ` 문자 제거
     * @param jws
     */
    private String extractToken(String jws) {
        return jws.substring("Bearer ".length());
    }
}
