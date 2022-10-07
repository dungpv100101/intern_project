package com.example.demo_keycloak_security_final.handler.query.keycloak;

import com.example.demo_keycloak_security_final.dto.request.query.LoginRequestData;
import com.example.demo_keycloak_security_final.dto.response.query.LoginResponseData;
import com.example.demo_keycloak_security_final.handler.query.QueryHandler;
import com.example.demo_keycloak_security_final.service.keycloak.KeycloakKeycloakUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler extends QueryHandler<LoginRequestData, LoginResponseData> {
    @Autowired
    protected KeycloakKeycloakUserService serviceUser;
    @Override
    public LoginResponseData handle(LoginRequestData request) {
        LoginResponseData loginResponseData = new LoginResponseData();
        loginResponseData.setResponse(serviceUser.login(request.getUsername(), request.getPassword()));

        return loginResponseData;
    }
}
