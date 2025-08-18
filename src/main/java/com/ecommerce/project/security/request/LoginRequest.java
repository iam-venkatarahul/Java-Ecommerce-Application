package com.ecommerce.project.security.request;

import jakarta.validation.constraints.*;
import lombok.*;

/*
 * This represents the data sent by the user to the app while logging in.
 * It contains fields for username and password, along with validation constraints.
 */



@Getter
@Setter
public class LoginRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}