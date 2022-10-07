package com.example.demo_keycloak_security_final.dto.request.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExceptionRequestData extends CommandRequestData {
    private Long code;
    private String description;
}
