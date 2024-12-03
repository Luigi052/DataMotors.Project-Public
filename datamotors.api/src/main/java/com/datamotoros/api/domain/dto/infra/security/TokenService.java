package com.datamotoros.api.domain.dto.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.datamotoros.api.entity.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


    @Service
    public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

        public String generateToken(User user) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                String token = JWT.create()
                        .withIssuer("auth-api")
                        .withSubject(user.getLogin())
                        .withKeyId(user.getId())
                        .withExpiresAt(genExpirationDate())
                        .withClaim("role", user.getRole().name())
                        .sign(algorithm);
                return token;
            } catch (JWTCreationException exception) {
                throw new RuntimeException("erro gerando o token", exception);
            }
        }


        public String validateToken(String token) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.require(algorithm)
                        .withIssuer("auth-api")
                        .build()
                        .verify(token)
                        .getSubject();
            } catch (JWTCreationException exception) {
                return "";
            }
        }
        private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
        }
    }
