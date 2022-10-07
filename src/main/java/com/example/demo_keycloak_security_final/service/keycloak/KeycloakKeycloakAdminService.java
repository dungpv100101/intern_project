package com.example.demo_keycloak_security_final.service.keycloak;

import com.example.demo_keycloak_security_final.config.KeycloakConfiguration;
import com.example.demo_keycloak_security_final.entity.UserInfo;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeycloakKeycloakAdminService implements KeycloakAdminService {
    @Autowired
    private KeycloakConfiguration keycloakConfiguration;
    @Override
    public Response register(UserInfo user) {
        Keycloak kc = getAdmin();

        if (kc.realm(keycloakConfiguration.getRealmUser()).users().search(user.getUsername()).size() > 0) {
            throw new ApplicationException(409L);
        }

        Response result = kc.realm(keycloakConfiguration.getRealmUser())
                .users()
                .create(getUserRepresentation(user));

        setUserRole(kc, CreatedResponseUtil.getCreatedId(result), "user");

        return result;
    }
    @Override
    public UserRepresentation getUserRepresentation(UserInfo user) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(user.getPassword());

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(user.getUsername());
        userRepresentation.setCredentials(Arrays.asList(credential));
        userRepresentation.setEnabled(true);
        userRepresentation.setRealmRoles(Arrays.asList("user"));
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());
        userRepresentation.setEmail(user.getEmail());

        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("phone", Arrays.asList(user.getPhone()));

        userRepresentation.setAttributes(attributes);

        return userRepresentation;
    }
    @Override
    public void setUserRole(Keycloak kc, String userId, String roleName) {
        RealmResource realmResource = kc.realm(keycloakConfiguration.getRealmUser());
        UsersResource usersResource = realmResource.users();

        RoleRepresentation testerRealmRole = realmResource.roles()
                .get(roleName).toRepresentation();

        UserResource userResource = usersResource.get(userId);
        userResource.roles().realmLevel()
                .add(Arrays.asList(testerRealmRole));
    }
    @Override
    public UserInfo getUserInfo(String userid) {
        Keycloak keycloak = getAdmin();

        UsersResource usersResource = keycloak.realm(keycloakConfiguration.getRealmUser()).users();
        UserResource userResource = usersResource.get(userid);

        UserRepresentation userRepresentation;

        try {
            userRepresentation = userResource.toRepresentation();
        } catch (Exception e) {
            throw new ApplicationException(404L);
        }

        UserInfo userInfo = UserInfo.builder()
                .username(userRepresentation.getUsername())
                .firstName(userRepresentation.getFirstName())
                .lastName(userRepresentation.getLastName())
                .email(userRepresentation.getEmail())
                .phone(userRepresentation.firstAttribute("phone"))
                .build();

        return userInfo;
    }
    @Override
    public Keycloak getAdmin() {
        Keycloak kc = Keycloak.getInstance(
                keycloakConfiguration.getServerUri(),
                keycloakConfiguration.getRealm(),
                keycloakConfiguration.getUsername(),
                keycloakConfiguration.getPassword(),
                keycloakConfiguration.getClientAdminId());
        return kc;
    }
}
