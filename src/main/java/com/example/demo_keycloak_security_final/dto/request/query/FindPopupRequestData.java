package com.example.demo_keycloak_security_final.dto.request.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindPopupRequestData extends QueryRequestData{
    private String langCode;
    private Long exceptionCode;
}
