package com.ecommerce.project.service;

import com.ecommerce.project.payload.AuthenticationResult;
import com.ecommerce.project.security.request.LoginRequest;
import com.ecommerce.project.security.request.SignUpRequest;
import com.ecommerce.project.security.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    
    AuthenticationResult login(LoginRequest loginRequest);

    ResponseEntity<MessageResponse> register(SignUpRequest signUpRequest);

    // UserInfoResponse getCurrentUserDetails(Authentication authentication);

    // ResponseCookie logoutUser();

    // UserResponse getAllSellers(Pageable pageable);
}
