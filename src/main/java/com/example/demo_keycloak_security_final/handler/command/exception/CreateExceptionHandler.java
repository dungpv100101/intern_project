package com.example.demo_keycloak_security_final.handler.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.exception.CreateExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.exception.CreateExceptionResponseData;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.exception.impl.ExceptionCommandServiceImpl;
import com.example.demo_keycloak_security_final.util.ExceptionCode;
import com.example.demo_keycloak_security_final.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateExceptionHandler extends CommandHandler<CreateExceptionRequestData, CreateExceptionResponseData> {
    private final ExceptionCommandServiceImpl exceptionCommandService;

    @Override
    public CreateExceptionResponseData handle(CreateExceptionRequestData request) {
        validateRequest(request);
        Exception exception = ModelMapperUtil.map(request, Exception.class);

        return new CreateExceptionResponseData(exceptionCommandService.create(exception));
    }

    private void validateRequest(CreateExceptionRequestData request) {
        if (request.getCode() == null) {
            //Throw this entity not acceptable exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }
    }
}
