package com.example.demo_keycloak_security_final.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeycloakConstants {
    public static final String REALM_CLAIM_NAME = "realm_access";
    public static final String ROLE_CLAIM_NAME = "roles";
    public static final String ROLE_MARK = "ROLE_";
}
