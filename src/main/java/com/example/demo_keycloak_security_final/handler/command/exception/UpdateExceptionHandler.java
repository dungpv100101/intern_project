package com.example.demo_keycloak_security_final.handler.command.exception;

import com.example.demo_keycloak_security_final.dto.request.command.exception.UpdateExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.exception.UpdateExceptionResponseData;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.exception.ExceptionCommandService;
import com.example.demo_keycloak_security_final.service.query.exception.ExceptionQueryService;
import com.example.demo_keycloak_security_final.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateExceptionHandler extends CommandHandler<UpdateExceptionRequestData, UpdateExceptionResponseData> {
    private final ExceptionCommandService exceptionCommandService;
    private final ExceptionQueryService exceptionQueryService;

    @Override
    public UpdateExceptionResponseData handle(UpdateExceptionRequestData request) {
        Exception exception = ModelMapperUtil.map(request, Exception.class);

        Exception fromDB = exceptionQueryService.findById(exception.getCode());

        fromDB.setCode(exception.getCode());
        fromDB.setDescription(exception.getDescription());

        return new UpdateExceptionResponseData(exceptionCommandService.update(fromDB));
    }
}
