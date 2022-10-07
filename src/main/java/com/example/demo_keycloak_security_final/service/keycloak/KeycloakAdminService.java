package com.example.demo_keycloak_security_final.service.keycloak;

import com.example.demo_keycloak_security_final.entity.UserInfo;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;

public interface KeycloakAdminService {
    Response register(UserInfo user);

    UserRepresentation getUserRepresentation(UserInfo user);

    void setUserRole(Keycloak kc, String userId, String roleName);

    public UserInfo getUserInfo(String userid);

    Keycloak getAdmin();
}
