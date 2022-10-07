package com.example.demo_keycloak_security_final.dto.request.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@Data
@AllArgsConstructor
public class FindExceptionRequestData extends QueryRequestData{
    private Long code;
}
