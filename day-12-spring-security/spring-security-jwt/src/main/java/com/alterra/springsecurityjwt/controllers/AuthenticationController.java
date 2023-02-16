package com.alterra.springsecurityjwt.controllers;

import com.alterra.springsecurityjwt.dtos.AuthenticationRequest;
import com.alterra.springsecurityjwt.dtos.AuthenticationResponse;
import com.alterra.springsecurityjwt.dtos.RegisterRequest;
import com.alterra.springsecurityjwt.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v2/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> decodeJwt(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(service.decodeJwt(authHeader));
    }


}
