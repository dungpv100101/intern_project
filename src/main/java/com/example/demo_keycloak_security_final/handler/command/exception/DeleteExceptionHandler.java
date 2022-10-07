package com.example.demo_keycloak_security_final.handler.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.exception.DeleteExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.exception.DeleteExceptionResponseData;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.exception.ExceptionCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteExceptionHandler extends CommandHandler<DeleteExceptionRequestData, DeleteExceptionResponseData> {
    private final ExceptionCommandService exceptionCommandService;
    @Override
    public DeleteExceptionResponseData handle(DeleteExceptionRequestData request) {
        Long code = exceptionCommandService.delete(request.getCode());

        return new DeleteExceptionResponseData(code);
    }
}
