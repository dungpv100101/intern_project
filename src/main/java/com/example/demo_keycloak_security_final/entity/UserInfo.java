package com.example.demo_keycloak_security_final.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
