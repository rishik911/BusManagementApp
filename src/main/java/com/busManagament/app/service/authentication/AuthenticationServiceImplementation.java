package com.busManagament.app.service.authentication;


import com.busManagament.app.model.User;
import com.busManagament.app.service.user.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long JWT_TOKEN_VALIDITY;

    @Override
    public String generateToken(String userName, String Password) throws Exception {
        User user = userService.validateUser(userName,Password);
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user.getUsername());
    }

    @Override
    public void isAuthenticated(HttpServletRequest request) throws Exception {
        final String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null) {
            try {
                String username = extractUsername(jwtToken);
                User user = userService.findByUserName(username);
                if (!validateToken(jwtToken, user)) throw new Exception("JWT Token is expired");
                if (!user.getRole().equals("admin") && !request.getMethod().equalsIgnoreCase("GET"))
                    throw new Exception("User is not admin, hence user cannot create or update records");
            } catch (Exception e) {
                throw new Exception("JWT Token is invalid");
            }
        } else {
            throw new Exception("JWT Token is not present");
        }
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY)).signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

    public boolean validateToken(String token, User user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}