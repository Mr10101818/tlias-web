package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET = "aXRoZWltYQ==";
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000; // 12 hours

    /**
     * 生成JWT令牌
     * @param dataMap 存储在令牌中的数据
     * @return 返回生成的JWT字符串
     */
    public static String generateToken(Map<String, Object> dataMap) {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param token 要解析的JWT字符串
     * @return 返回令牌中存储的数据
     */
    public static Claims parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}