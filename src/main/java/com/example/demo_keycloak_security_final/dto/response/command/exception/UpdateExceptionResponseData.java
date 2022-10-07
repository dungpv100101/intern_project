package com.example.demo_keycloak_security_final.dto.response.command.exception;

import com.example.demo_keycloak_security_final.dto.response.command.CommandResponseData;
import com.example.demo_keycloak_security_final.entity.Exception;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UpdateExceptionResponseData extends CommandResponseData {
    private Exception exception;
}
