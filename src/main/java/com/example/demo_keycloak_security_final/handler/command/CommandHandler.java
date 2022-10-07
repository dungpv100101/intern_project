package com.example.demo_keycloak_security_final.handler.command;

import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.CommandResponseData;
import com.example.demo_keycloak_security_final.handler.IHandler;

public abstract class CommandHandler <T extends CommandRequestData, I extends CommandResponseData> implements IHandler<T, I> {
}
