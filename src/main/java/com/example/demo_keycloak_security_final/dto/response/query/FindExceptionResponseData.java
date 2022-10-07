package com.example.demo_keycloak_security_final.dto.response.query;

import com.example.demo_keycloak_security_final.entity.Exception;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FindExceptionResponseData extends QueryResponseData {
    private Exception exception;
}
