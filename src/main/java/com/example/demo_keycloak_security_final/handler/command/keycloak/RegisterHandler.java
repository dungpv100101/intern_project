package com.example.demo_keycloak_security_final.handler.command.keycloak;

import com.example.demo_keycloak_security_final.dto.request.command.RegisterRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.RegisterResponseData;
import com.example.demo_keycloak_security_final.entity.UserInfo;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.keycloak.KeycloakKeycloakAdminService;
import com.example.demo_keycloak_security_final.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler extends CommandHandler<RegisterRequestData, RegisterResponseData> {
    @Autowired
    private KeycloakKeycloakAdminService service;
    @Override
    public RegisterResponseData handle(RegisterRequestData request) {

        UserInfo user = ModelMapperUtil.map(request, UserInfo.class);

        return new RegisterResponseData(service.register(user));
    }
}
