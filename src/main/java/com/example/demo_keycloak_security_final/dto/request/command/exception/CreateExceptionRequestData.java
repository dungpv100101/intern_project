package com.example.demo_keycloak_security_final.dto.request.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExceptionRequestData extends CommandRequestData {
    private Long code;
    private String description;
}
