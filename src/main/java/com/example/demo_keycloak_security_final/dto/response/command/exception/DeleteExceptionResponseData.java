package com.example.demo_keycloak_security_final.dto.response.command.exception;

import com.example.demo_keycloak_security_final.dto.response.command.CommandResponseData;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteExceptionResponseData extends CommandResponseData {
    private Long code;
}
