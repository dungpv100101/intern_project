package com.example.demo_keycloak_security_final.dto.response.query;

import lombok.*;
import org.keycloak.representations.AccessTokenResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseData extends QueryResponseData {
    private AccessTokenResponse response;
}
