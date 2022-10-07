package com.example.demo_keycloak_security_final.handler.query.exception;

import com.example.demo_keycloak_security_final.dto.request.query.FindExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.response.query.FindExceptionResponseData;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.handler.query.QueryHandler;
import com.example.demo_keycloak_security_final.service.query.exception.ExceptionQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindExceptionHandler extends QueryHandler<FindExceptionRequestData, FindExceptionResponseData> {
    private final ExceptionQueryService exceptionQueryService;

    @Override
    public FindExceptionResponseData handle(FindExceptionRequestData request) {
        return new FindExceptionResponseData(getException(request));
    }

    private Exception getException(FindExceptionRequestData request) {
        return exceptionQueryService.findById(request.getCode());
    }
}
