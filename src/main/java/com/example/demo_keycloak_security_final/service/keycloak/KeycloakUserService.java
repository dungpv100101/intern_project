package com.example.demo_keycloak_security_final.service.keycloak;

import org.keycloak.representations.AccessTokenResponse;

public interface KeycloakUserService {
    AccessTokenResponse login(String username, String password);
}
