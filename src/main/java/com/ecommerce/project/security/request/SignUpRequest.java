package com.ecommerce.project.security.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Setter
@Getter
public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Email  
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    
    private Set<String> roles; // Assuming roles are stored as a set of strings
}
