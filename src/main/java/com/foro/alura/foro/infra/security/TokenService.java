package com.foro.alura.foro.infra.security;

import com.foro.alura.foro.modelo.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;



@Service

public class TokenService {

        @Value("${api.security.secret}")
        private String apiSecret;

        public String generarToken(Usuario usuario) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret);
                return JWT.create()
                        .withIssuer("foro")
                        .withSubject(usuario.getLogin())
                        .withClaim("id", usuario.getId())
                        .withExpiresAt(generarFechaExpiracion())
                        .sign(algorithm);
            } catch (JWTCreationException exception){
                throw new RuntimeException();
            }
        }

        public String getSubject(String token) {
            if (token == null) {
                throw new RuntimeException();
            }

            try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
               DecodedJWT verifier = JWT.require(algorithm)
                        .withIssuer("foro")
                        .build()
                        .verify(token);
                return verifier.getSubject();
            } catch (JWTVerificationException exception) {
                System.out.println(exception.toString());

            }

                throw new RuntimeException("Verifier invalido");

        }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWT.require(algorithm)
                    .withIssuer("foro")
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }


    private Instant generarFechaExpiracion() {
            return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
        }
}
