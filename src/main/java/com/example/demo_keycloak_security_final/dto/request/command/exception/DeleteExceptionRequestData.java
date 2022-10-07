package com.example.demo_keycloak_security_final.dto.request.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteExceptionRequestData extends CommandRequestData {
    private Long code;
}
