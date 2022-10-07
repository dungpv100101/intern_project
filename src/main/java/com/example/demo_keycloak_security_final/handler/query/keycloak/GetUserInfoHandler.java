package com.example.demo_keycloak_security_final.handler.query.keycloak;

import com.example.demo_keycloak_security_final.dto.request.query.GetUserRequestData;
import com.example.demo_keycloak_security_final.dto.response.query.GetUserResponseData;
import com.example.demo_keycloak_security_final.entity.UserInfo;
import com.example.demo_keycloak_security_final.handler.query.QueryHandler;
import com.example.demo_keycloak_security_final.service.keycloak.KeycloakKeycloakAdminService;
import com.example.demo_keycloak_security_final.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetUserInfoHandler extends QueryHandler<GetUserRequestData, GetUserResponseData> {
    private final KeycloakKeycloakAdminService serviceAdmin;
    @Override
    public GetUserResponseData handle(GetUserRequestData request) {
        UserInfo userInfo = serviceAdmin.getUserInfo(request.getUserID());

        GetUserResponseData getUserResponseData = ModelMapperUtil.map(userInfo, GetUserResponseData.class);
        return getUserResponseData;
    }
}
