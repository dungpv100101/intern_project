package com.example.demo_keycloak_security_final.dto.request.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletePopupRequestData extends CommandRequestData {
    private Long id;
    private Long exceptionCode;
    private String langCode;

    public DeletePopupRequestData(Long exceptionCode, String langCode) {
        this.exceptionCode = exceptionCode;
        this.langCode = langCode;
    }

    public DeletePopupRequestData(Long id) {
        this.id = id;
    }
}
