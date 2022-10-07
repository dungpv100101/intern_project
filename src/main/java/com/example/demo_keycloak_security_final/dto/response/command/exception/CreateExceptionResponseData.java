package com.example.demo_keycloak_security_final.dto.response.command.exception;

import com.example.demo_keycloak_security_final.dto.response.command.CommandResponseData;
import com.example.demo_keycloak_security_final.entity.Exception;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class CreateExceptionResponseData extends CommandResponseData {
    private Exception exception;
}
