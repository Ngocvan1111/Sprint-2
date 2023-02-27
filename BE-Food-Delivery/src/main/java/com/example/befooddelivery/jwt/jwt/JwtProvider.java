package com.example.befooddelivery.jwt.jwt;

import com.example.befooddelivery.jwt.userprincal.AccountPrincal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "vanngoc"; // Chữ ký của token
    private final int jwtExpiration = 86400;
    public String createToken(Authentication authentication){
        AccountPrincal accountPrincal = (AccountPrincal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(accountPrincal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date (new Date().getTime()+ jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    public boolean validateToken(String token) { // valid token
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return true;

        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {Token không hộ trợ}", e);
        } catch (MalformedJwtException e) {
            logger.error("The token invalid format -> Message: {Token không đúng định dạng}", e);

        } catch (SignatureException e) {
            logger.error("Invalid JWT Signature -> Message: {Token không hợp lệ}", e);

        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {Token có khoảng trắng}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {thời gian sống}", e);
        }
        return false;
    }

    public String getUserNameFromToken(String token){
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject(); // lấy ra
        return username;
    }
}
