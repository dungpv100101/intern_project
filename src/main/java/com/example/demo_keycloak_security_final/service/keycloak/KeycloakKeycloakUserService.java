package com.example.demo_keycloak_security_final.service.keycloak;

import com.example.demo_keycloak_security_final.config.KeycloakConfiguration;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeycloakKeycloakUserService implements KeycloakUserService {

    @Autowired
    private KeycloakConfiguration  keycloakConfiguration;
    @Override
    public AccessTokenResponse login(String username, String password) {
        Keycloak keycloak = Keycloak.getInstance(
                keycloakConfiguration.getServerUri(),
                keycloakConfiguration.getRealmUser(),
                username,
                password,
                keycloakConfiguration.getClientId());

        try {
            return keycloak.tokenManager().getAccessToken();
        } catch (Exception e) {
            throw new ApplicationException(401L);
        }
    }
}
