package com.example.demo_keycloak_security_final.dto.response.command;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.core.Response;

@Getter
@Setter
@AllArgsConstructor
public class RegisterResponseData extends CommandResponseData {
    private Response response;
}
