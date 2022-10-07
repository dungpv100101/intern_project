package com.example.demo_keycloak_security_final.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationException extends RuntimeException{
    private Long responseCode;
}
