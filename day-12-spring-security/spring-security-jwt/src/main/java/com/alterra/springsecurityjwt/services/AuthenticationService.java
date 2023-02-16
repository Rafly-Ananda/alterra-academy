package com.alterra.springsecurityjwt.services;

import com.alterra.springsecurityjwt.dtos.AuthenticationRequest;
import com.alterra.springsecurityjwt.dtos.AuthenticationResponse;
import com.alterra.springsecurityjwt.dtos.RegisterRequest;
import com.alterra.springsecurityjwt.entities.UserEntity;
import com.alterra.springsecurityjwt.enums.UserRole;
import com.alterra.springsecurityjwt.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = UserEntity.builder()
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();
        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhone(),
                        request.getPassword()
                )
        );
        var user = repository.findByPhone(request.getPhone())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public Map<String, Object> decodeJwt(String authHeader) {
        String token = authHeader.substring(7);
        String userPhone = jwtService.extractClaim(token, Claims::getSubject);

        return new HashMap<>(){{
            put("data", new HashMap<>(){{
                put("phone", userPhone);
            }});
        }};
    }

}
