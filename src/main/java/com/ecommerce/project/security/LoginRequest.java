package com.ecommerce.project.security;

import lombok.*;

@Getter
@Setter
public class LoginRequest {
    private String username;

    private String password;
}