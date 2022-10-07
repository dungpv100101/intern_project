package com.example.demo_keycloak_security_final.dto.request.query;

import com.example.demo_keycloak_security_final.dto.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestData extends QueryRequestData {
    private String username;
    private String password;
}
