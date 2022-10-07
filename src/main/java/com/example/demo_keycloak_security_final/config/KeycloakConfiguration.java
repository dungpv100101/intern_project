package com.example.demo_keycloak_security_final.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class KeycloakConfiguration {

    @Value("${keycloak.server-uri}")
    private String serverUri;
    @Value("${keycloak.client-id.admin}")
    private String clientAdminId;

    @Value("${keycloak.authorization-grant-type}")
    private String grantType;
    @Value("${keycloak.realm.admin}")
    private String realm;
    @Value("${keycloak.realm.user}")
    private String realmUser;
    @Value("${keycloak.admin.username}")
    private String username;
    @Value("${keycloak.admin.password}")
    private String password;
    @Value("${keycloak.client-id.user}")
    private String clientId;
}
