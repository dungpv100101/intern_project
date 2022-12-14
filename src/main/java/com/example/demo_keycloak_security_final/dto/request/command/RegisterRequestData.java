package com.example.demo_keycloak_security_final.dto.request.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestData extends CommandRequestData{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
