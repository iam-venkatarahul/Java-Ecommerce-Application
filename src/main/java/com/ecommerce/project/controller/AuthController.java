package com.ecommerce.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.security.request.LoginRequest;
import com.ecommerce.project.security.request.SignUpRequest;
import com.ecommerce.project.service.AuthService;

import jakarta.validation.Valid;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController { 

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        AuthenticationResult result = authService.login(loginRequest);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
                result.getJwtCookie().toString())
                .body(result.getResponse());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.register(signUpRequest);
    }

    

    
}
