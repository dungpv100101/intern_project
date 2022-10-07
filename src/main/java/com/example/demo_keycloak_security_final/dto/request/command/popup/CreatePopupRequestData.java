package com.example.demo_keycloak_security_final.dto.request.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import com.example.demo_keycloak_security_final.entity.Button;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePopupRequestData extends CommandRequestData {
    private Long exceptionCode;
    private String langCode;
    private Long buttonId;
    private String title;
    private String content;
}
