package dev.mivas.BarberSystem.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.mivas.BarberSystem.User.entity.UsersModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${barbersystem.security.secret}")
    private String secret;

    public String generateToken(UsersModel user){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(8600))
                .withIssuedAt(Instant.now())
                .withIssuer("barberSystem API")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return  Optional.of(JWTUserData
                    .builder()
                    .id(jwt.getClaim("userId").asLong())
                    .name(jwt.getClaim("name").asString())
                    .email(jwt.getClaim("email").asString())
                    .build());

        }catch (JWTVerificationException ex){
            return  Optional.empty();
        }
    }
}
