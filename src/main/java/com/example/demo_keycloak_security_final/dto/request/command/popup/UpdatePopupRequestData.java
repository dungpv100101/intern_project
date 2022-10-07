package com.example.demo_keycloak_security_final.dto.request.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import com.example.demo_keycloak_security_final.entity.Button;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePopupRequestData extends CommandRequestData {
    private Long id;
    private Long exceptionCode;
    private String langCode;
    private Long buttonId;
    private String title;
    private String content;
}
