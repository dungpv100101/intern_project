package com.example.demo_keycloak_security_final.handler.query;

import com.example.demo_keycloak_security_final.dto.request.query.QueryRequestData;
import com.example.demo_keycloak_security_final.dto.response.query.QueryResponseData;
import com.example.demo_keycloak_security_final.handler.IHandler;

public abstract class QueryHandler <T extends QueryRequestData, I extends QueryResponseData> implements IHandler<T, I> {

}
