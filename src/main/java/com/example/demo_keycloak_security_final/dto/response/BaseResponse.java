package com.example.demo_keycloak_security_final.dto.response;

import lombok.Data;

@Data
public class BaseResponse <T extends ResponseData>{
    private int responseCode;
    private T responseData;
    private String message;
}
