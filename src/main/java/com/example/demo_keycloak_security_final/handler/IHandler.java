package com.example.demo_keycloak_security_final.handler;

import com.example.demo_keycloak_security_final.dto.request.RequestData;
import com.example.demo_keycloak_security_final.dto.response.ResponseData;

public interface IHandler <T extends RequestData, I extends ResponseData>{
    I handle(T request);
}
