package com.example.demo_keycloak_security_final.dto.response.command.popup;

import com.example.demo_keycloak_security_final.dto.response.command.CommandResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DeletePopupResponseData extends CommandResponseData {
    private int numberOfRowDeleted;
}
